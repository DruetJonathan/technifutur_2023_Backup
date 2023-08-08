package com.babiarzdruet.labojavadataweb.services;

import com.babiarzdruet.labojavadataweb.models.entities.Game;
import com.babiarzdruet.labojavadataweb.models.entities.RequestCoaching;

import java.util.List;

public interface RequestCoachingService {

    RequestCoaching add(RequestCoaching requestCoaching);
    RequestCoaching getOne(Long id);
    List<RequestCoaching> getAll();
    RequestCoaching update(RequestCoaching requestCoaching);
    RequestCoaching delete(Long id);
}
