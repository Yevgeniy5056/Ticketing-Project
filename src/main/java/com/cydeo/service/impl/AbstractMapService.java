package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T, U> {

    public Map<U, T> map = new HashMap<>();

    T save(U id, T object) {
        map.put(id, object);
        return object;
    }

    List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    T findById(U id) {
        return map.get(id);
    }

    void deleteById(U id) {
        map.remove(id);
    }
}
