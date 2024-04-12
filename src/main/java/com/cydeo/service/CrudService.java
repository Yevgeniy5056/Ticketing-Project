package com.cydeo.service;

import java.util.List;

public interface CrudService<T, U> {

    T save(T object);

    T findById(U unique);

    List<T> findAll();

    void delete(U unique);

    void update(T object);
}
