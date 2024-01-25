package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.InputDTO;
import com.myfinances.users.dtos.inputs.UpdateDTO;
import com.myfinances.users.dtos.views.ViewDTO;
import com.myfinances.users.entities.EntityModel;
import com.myfinances.users.infrastructure.Repo;

import java.util.List;
import java.util.Optional;

public abstract class CRUDService<Entity extends EntityModel, EntityId, InputDTOImp extends InputDTO<Entity>, UpdateDTOImp extends UpdateDTO<Entity, EntityId>, ViewDTOImp extends ViewDTO> {

    protected final Repo<Entity, EntityId> repo;

    public CRUDService(Repo<Entity, EntityId> repo) {
        this.repo = repo;
    }

    public Optional<ViewDTOImp> getById(EntityId entityId) {
        Optional<Entity> entity = this.repo.findById(entityId);
        return entity.map(e -> toView(e));
    }

    public List<ViewDTOImp> getAll() {
        List<Entity> entities = this.repo.findAll();
        return entities.stream().map(entity ->  toView(entity)).toList();
    }

    public Entity create(InputDTOImp dto) {
        return this.repo.save(dto.toEntity());
    }

    public Entity update(UpdateDTOImp dto) {
        Entity entity = this.repo.findById(dto.getId()).get();
        return this.repo.save(dto.toEntity(entity));
    }

    public void deleteById(EntityId entityId) {
        this.repo.deleteById(entityId);
    }

    protected abstract ViewDTOImp toView(Entity entity);
}
