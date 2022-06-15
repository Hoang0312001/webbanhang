package com.example.storefurniture.service.impl;

import com.example.storefurniture.Exception.JsonException;
import com.example.storefurniture.JpaRepository.ProductRepository;
import com.example.storefurniture.dto.Request.product.ProductRequest;
import com.example.storefurniture.dto.Response.Brand.BrandResponse;
import com.example.storefurniture.dto.Response.category.CategoryResponse;
import com.example.storefurniture.dto.Response.product.ProductResponse;
import com.example.storefurniture.entity.Brand;
import com.example.storefurniture.entity.Category;
import com.example.storefurniture.entity.Image;
import com.example.storefurniture.entity.Product;
import com.example.storefurniture.mapper.request.ProductSaveMapper;
import com.example.storefurniture.mapper.response.BrandMapper;
import com.example.storefurniture.mapper.response.CategoryMapper;
import com.example.storefurniture.mapper.response.ProductMapper;
import com.example.storefurniture.page.Pages;
import com.example.storefurniture.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.storefurniture.constant.Constant.STATUS;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSaveMapper productSaveMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    private final ImageService imageService;
    private final BrandService brandService;
    private final CategoryService categoryService;



    @Override
    public ResponseEntity<Pages> getAllProductByPage(Pages pages) {
                 if (pages.getPage() > 0 && pages.getLimit() > 0){
             Pageable pageable = PageRequest.of(pages.getPage()-1,pages.getLimit());
             pages.setListResult(findAll(pageable));
             pages.setTotalPage((int) Math.ceil((double) (totalPage())/pages.getLimit()));
             Pages<Product> productPages = pages;
             return ResponseEntity.ok(productPages);
         }
         return new ResponseEntity(new JsonException(500,"page , limit lon hoac bang 1 "),HttpStatus.BAD_REQUEST);
    }
    public List<ProductResponse> findAll(Pageable pageable){
                List<ProductResponse> productResponseList = new ArrayList<>();
        List<Product> productsEntity = productRepository.findAll(pageable).getContent();
        for (Product product : productsEntity){
            ProductResponse productResponse = productMapper.from(product);
            productResponseList.add(productResponse);
        }

        return productResponseList;
    }
    @Override
    public ResponseEntity<?> save(ProductRequest productRequest) {
        if (productRequest != null && productRequest.getId_category() != 0 && productRequest.getId_brand() != 0){
            Product product = productSaveMapper.to(productRequest);
            List<Image> images = getImages(productRequest);
            Brand brand = getBrand(productRequest);
            Category category = getCategory(productRequest);
            if (images != null){
                product.setImage(images);
            }
            product.setBrand(brand);
            product.setCategory(category);
            product.setStatus(STATUS);
            productRepository.save(product);
            return ResponseEntity.ok("Thêm sản phẩm thành công");
        }
        return new ResponseEntity<>(new JsonException(400,"Thiêu thông tin"), HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<?> deleteByID(long[] ids) {
        for (long id : ids){
            productRepository.deleteById(id);
        }
        return ResponseEntity.ok("Xoa thanh cong");
    }

    @Override
    public int totalPage() {
        return (int) productRepository.count();
    }

    public List<Image> getImages(ProductRequest productRequest){
            if (productRequest.getImageIds() != null){
                List<Image>  listImage = new ArrayList<>();
                List<Long> productListId = productRequest.getImageIds();
                for (Long idImage : productListId){
                    Image images =  imageService.findOneById(idImage);
                    listImage.add(images);

                }
                return listImage;
            }
            return null;
    }
    public Brand getBrand(ProductRequest productRequest){
        if (productRequest.getId_brand() != 0){
            BrandResponse brandResponse = brandService.findOneById(productRequest.getId_brand());
            return  brandMapper.to(brandResponse);
        }
        return null;
    }
    public Category getCategory(ProductRequest productRequest){
        if (productRequest.getId_category() != 0){
            CategoryResponse category = categoryService.findOneById(productRequest.getId_category());

            return categoryMapper.to(category);
        }
        return null;
    }
//    public List<Image> getListImage(ProductRequest productRequest){
//        if (productRequest.getImageIds() != null){
//            List<Image> images = new ArrayList<>();
//            List<Long> productListId = productRequest.getImageIds();
//            for (Long idImage : productListId ){
//                    List<Image> image = imageService.findOneById(idImage);
//                      images.add((Image) image);
//            }
//            return  images;
//
//        }
//        return null;
//    }

}
