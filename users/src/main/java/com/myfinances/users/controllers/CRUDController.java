package com.myfinances.users.controllers;

import com.myfinances.users.dtos.inputs.InputDTO;
import com.myfinances.users.dtos.inputs.UpdateDTO;
import com.myfinances.users.entities.EntityModel;
import com.myfinances.users.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CRUDController<Entity extends EntityModel, EntityId, InputDTOImp extends InputDTO<Entity>, UpdateDTOImp extends UpdateDTO<Entity, EntityId>> {

    protected final CRUDService<Entity, EntityId, InputDTOImp, UpdateDTOImp> service;

    @Autowired
    public CRUDController(CRUDService<Entity, EntityId, InputDTOImp, UpdateDTOImp> service) {
        this.service = service;
    }

    @GetMapping("get/{entityId}")
    public Optional<Entity> getById(@PathVariable EntityId entityId) {
        return this.service.getById(entityId);
    }

    @GetMapping("get-all")
    public List<Entity> getAll() {
        return this.service.getAll();
    }

    @PostMapping("create")
    public Entity create(@RequestBody InputDTOImp dto) {
        return this.service.create(dto);
    }

    @PutMapping("update")
    public Entity update(@RequestBody UpdateDTOImp dto) {
        return this.service.update(dto);
    }

    @DeleteMapping("delete/{entityId}")
    public void deleteById(@PathVariable EntityId entityId) {
        this.service.deleteById(entityId);
    }

}
