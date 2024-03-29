package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.InputDTO;
import com.myfinances.users.dtos.inputs.UpdateDTO;
import com.myfinances.users.dtos.views.ViewDTO;
import com.myfinances.users.entities.EntityModel;
import com.myfinances.users.infrastructure.Repo;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class CRUDService<Entity extends EntityModel, EntityId, InputDTOImp extends InputDTO<Entity>, UpdateDTOImp extends UpdateDTO<Entity, EntityId>, ViewDTOImp extends ViewDTO> {

    protected final Repo<Entity, EntityId> repo;

    public Optional<ViewDTOImp> getById(EntityId entityId) {
        return this.repo.findById(entityId)
                .map(this::toView);
    }

    public List<ViewDTOImp> getAll() {
        return this.repo.findAll().stream()
                .map(this::toView)
                .toList();
    }

    public Entity create(InputDTOImp dto) {
        return this.repo.save(dto.toEntity());
    }

    public Entity update(UpdateDTOImp dto) {
        Entity entity = this.repo.findById(dto.getId())
                .orElseThrow();
        return this.repo.save(dto.toEntity(entity));
    }

    public void deleteById(EntityId entityId) {
        this.repo.deleteById(entityId);
    }

    protected abstract ViewDTOImp toView(Entity entity);
}
