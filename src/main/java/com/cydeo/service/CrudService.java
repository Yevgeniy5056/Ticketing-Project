package com.cydeo.service;

import java.util.List;

public interface CrudService<T, U> {

    T save(T t);

    T findById(U u);

    List<T> findAll();

    void delete(U u);
}
