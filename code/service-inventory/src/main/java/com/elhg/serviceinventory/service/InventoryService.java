package com.elhg.serviceinventory.service;

import com.elhg.serviceinventory.dto.InventoryRequest;
import com.elhg.serviceinventory.dto.InventoryResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryService {
    Mono<InventoryResponse> createInventory(Mono<InventoryRequest> inventory);
    Mono<InventoryResponse> getInventory(String code);
    Flux<InventoryResponse> getList();
}


