package com.myfinances.apigateway.services;

import com.myfinances.apigateway.entities.EntityModel;
import com.myfinances.apigateway.models.request.InputRequest;
import com.myfinances.apigateway.models.request.UpdateRequest;
import com.myfinances.apigateway.models.response.ViewResponse;
import org.springframework.web.client.RestClient;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class CRUDService<Entity extends EntityModel, EntityId, InputImp extends InputRequest, UpdateImp extends UpdateRequest<EntityId>, ViewImp extends ViewResponse> {
    protected final RestClient restClient;
    private final Class<Entity> entityTypeParameterClass;
    private final Class<ViewImp> viewTypeParameterClass;

    public CRUDService(String baseUrl, String controllerPath) {
        restClient = RestClient.builder().baseUrl(baseUrl + controllerPath).build();

        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        this.entityTypeParameterClass = (Class<Entity>) types[0];
        this.viewTypeParameterClass = (Class<ViewImp>) types[4];
    }

    public Optional<ViewImp> getById(EntityId entityId) {
        ViewImp result = restClient.get()
                .uri("/get/" + entityId)
                .retrieve()
                .body(viewTypeParameterClass);

        return result != null ? Optional.of(result) : Optional.empty();
    }

    public List<ViewImp> getAll() {
        List<ViewImp> result = restClient.get()
                .uri("/get-all")
                .retrieve()
                .body(List.class);

        return result;
    }

    public Entity create(InputImp body) {
        Entity result = restClient.post()
                .uri("/create")
                .body(body)
                .retrieve()
                .body(entityTypeParameterClass);

        return result;
    }

    public Entity update(UpdateImp body) {
        Entity result = restClient.put()
                .uri("/update")
                .body(body)
                .retrieve()
                .body(entityTypeParameterClass);

        return result;
    }

    public void deleteById(EntityId entityId) {
        restClient.delete()
                .uri("/delete/" + entityId)
                .retrieve()
                .toBodilessEntity();
    }
}