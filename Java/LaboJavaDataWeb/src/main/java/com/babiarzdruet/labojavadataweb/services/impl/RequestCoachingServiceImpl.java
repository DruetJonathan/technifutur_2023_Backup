package com.babiarzdruet.labojavadataweb.services.impl;

import com.babiarzdruet.labojavadataweb.models.entities.RequestCoaching;
import com.babiarzdruet.labojavadataweb.repositories.RequestCoachingRepository;
import com.babiarzdruet.labojavadataweb.repositories.impl.RequestCoachingRepositoryImpl;
import com.babiarzdruet.labojavadataweb.services.RequestCoachingService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@SessionScoped
public class RequestCoachingServiceImpl implements RequestCoachingService, Serializable {

    @Inject
    RequestCoachingRepository requestCoachingRepository;

    public RequestCoachingServiceImpl() {
        this.requestCoachingRepository = new RequestCoachingRepositoryImpl();
    }

    @Override
    public RequestCoaching add(RequestCoaching requestCoaching) {
        return this.requestCoachingRepository.add(requestCoaching);
    }

    @Override
    public RequestCoaching getOne(Long id) {
        Optional<RequestCoaching> requestCoaching = requestCoachingRepository.getOne(id);
        if (requestCoaching.isEmpty()){
            throw new RuntimeException("No coach request with id : " + id);
        }
        return requestCoaching.get();
    }

    @Override
    public List<RequestCoaching> getAll() {
        return requestCoachingRepository.getAll();
    }

    @Override
    public RequestCoaching update(RequestCoaching requestCoaching) {
        return requestCoachingRepository.update(requestCoaching);
    }

    @Override
    public RequestCoaching delete(Long id) {
        return requestCoachingRepository.delete(id);
    }
}
