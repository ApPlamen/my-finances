package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.entities.EntityModel;
import com.myfinances.apigateway.models.request.InputRequest;
import com.myfinances.apigateway.models.request.UpdateRequest;
import com.myfinances.apigateway.models.response.ViewResponse;
import com.myfinances.apigateway.services.CRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class CRUDController<Entity extends EntityModel, EntityId, InputDTOImp extends InputRequest, UpdateDTOImp extends UpdateRequest<EntityId>, ViewDTOImp extends ViewResponse> {

    protected final CRUDService<Entity, EntityId, InputDTOImp, UpdateDTOImp, ViewDTOImp> service;

    public CRUDController(CRUDService<Entity, EntityId, InputDTOImp, UpdateDTOImp, ViewDTOImp> service) {
        this.service = service;
    }

    @GetMapping("get/{entityId}")
    public ResponseEntity<Optional<ViewDTOImp>> getById(@PathVariable EntityId entityId) {
        Optional<ViewDTOImp> response = this.service.getById(entityId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<ViewDTOImp>> getAll() {
        List<ViewDTOImp> response = this.service.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<Entity> create(@RequestBody InputDTOImp dto) {
        Entity response = this.service.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("update")
    public ResponseEntity<Entity> update(@RequestBody UpdateDTOImp dto) {
        Entity response = this.service.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{entityId}")
    public void deleteById(@PathVariable EntityId entityId) {
        this.service.deleteById(entityId);
    }

}
