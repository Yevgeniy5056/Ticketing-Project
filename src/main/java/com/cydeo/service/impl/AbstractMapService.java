package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T, U> {

    public Map<U, T> map = new HashMap<>();

    T save(U unique, T object) {
        map.put(unique, object);
        return object;
    }

    List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    T findById(U unique) {
        return map.get(unique);
    }

    void deleteById(U unique) {
        map.remove(unique);
    }

    void update(U unique, T object) {
        map.put(unique, object);
    }
}
