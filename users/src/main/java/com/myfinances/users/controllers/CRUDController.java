package com.myfinances.users.controllers;

import com.myfinances.users.dtos.inputs.InputDTO;
import com.myfinances.users.dtos.inputs.UpdateDTO;
import com.myfinances.users.dtos.views.ViewDTO;
import com.myfinances.users.entities.EntityModel;
import com.myfinances.users.services.CRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CRUDController<Entity extends EntityModel, EntityId, InputDTOImp extends InputDTO<Entity>, UpdateDTOImp extends UpdateDTO<Entity, EntityId>, ViewDTOImp extends ViewDTO> {

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
