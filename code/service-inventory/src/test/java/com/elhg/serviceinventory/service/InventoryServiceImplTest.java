package com.elhg.serviceinventory.service;

import com.elhg.serviceinventory.dto.InventoryResponse;
import com.elhg.serviceinventory.model.entity.ProductModel;
import com.elhg.serviceinventory.model.mapper.InventoryMapper;
import com.elhg.serviceinventory.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventoryServiceImplTest {
    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @Test
    void getInventory() {
        // Test case for getting an inventory item by code
        String code = "P001";
        ProductModel productModel = ProductModel.builder()
                .id(1)
                .code(code)
                .nameProduct("Product 1")
                .stock(100)
                .price(new BigDecimal("19.99"))
                .build();

        when(inventoryRepository.findByCode(code)).thenReturn(Mono.just(productModel));
        inventoryService.getInventory(code).subscribe(response -> {
            assertNotNull(response);
            assertEquals(code, response.getIdProduct());
            assertEquals("Product 1", response.getNameProduct());
            assertEquals(100, response.getStock());
        });
    }

    @Test
    void getList() {
    }

    @Test
    void createInventory() {
    }
}