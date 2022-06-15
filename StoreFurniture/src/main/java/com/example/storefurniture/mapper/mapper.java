package com.example.storefurniture.mapper;

import java.util.List;

public interface mapper<S,D>{
    S to (D obj);
    D from(S obj);
    List<S> to (List<D> obj);
    List<D> from(List<S> obj);
}
