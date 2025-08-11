package com.elhg.serviceinventory.model.mapper;

import com.elhg.serviceinventory.dto.InventoryRequest;
import com.elhg.serviceinventory.dto.InventoryResponse;
import com.elhg.serviceinventory.model.entity.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    @Mapping(target = "code", source = "idProduct")
    ProductModel requestToModel(InventoryRequest request);

    @Mapping(target = "idProduct", source = "code")
    InventoryResponse modelToResponse(ProductModel productModel);

}
