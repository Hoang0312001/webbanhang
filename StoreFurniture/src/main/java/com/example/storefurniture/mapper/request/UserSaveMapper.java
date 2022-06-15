package com.example.storefurniture.mapper.request;

import com.example.storefurniture.dto.Request.user.UserSaveRequest;
import com.example.storefurniture.entity.User;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface UserSaveMapper extends mapper<User, UserSaveRequest> {
}
