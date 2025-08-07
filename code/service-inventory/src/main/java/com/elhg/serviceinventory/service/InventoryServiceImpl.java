package com.elhg.serviceinventory.service;

import com.elhg.serviceinventory.dto.InventoryRequest;
import com.elhg.serviceinventory.dto.InventoryResponse;
import com.elhg.serviceinventory.model.mapper.InventoryMapper;
import com.elhg.serviceinventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public Mono<InventoryResponse> getInventory(String code) {
        return inventoryRepository.findByCode(code)
                .map(InventoryMapper.INSTANCE::modelToResponse);
    }

    @Override
    public Flux<InventoryResponse> getList() {
       return inventoryRepository.findAll()
                .map(InventoryMapper.INSTANCE::modelToResponse);
    }

    @Override
    public Mono<InventoryResponse> createInventory(Mono<InventoryRequest> inventory) {
        return inventory.flatMap(request -> inventoryRepository.existsByCode(request.getIdProduct())
                .flatMap(exists -> exists ? Mono.empty() : inventoryRepository.save(InventoryMapper.INSTANCE.requestToModel(request))
                                .map(InventoryMapper.INSTANCE::modelToResponse)));


        /*return inventory.map(InventoryMapper.INSTANCE::requestToModel)
                .flatMap(value -> inventoryRepository.existsByCode(value.getCode())
                        .flatMap(existsProduct -> existsProduct ? Mono.empty() : inventoryRepository.save(value)))
                .map(InventoryMapper.INSTANCE::modelToResponse);*/
    }
}

