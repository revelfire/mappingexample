package com.revelfire.example.service;

import com.revelfire.example.model.Identifiable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class CrudService <T extends Identifiable> {

    protected abstract CrudRepository<T, Long> getRepository();

    public T read(Long readId) {
        return getRepository().findOne(readId);
    }

    public T save(T toSave) {
        return getRepository().save(toSave);
    }

    public Iterable<T> save(List<T> toSave) {
        return getRepository().save(toSave);
    }

    public void delete(Long deleteId) {
        getRepository().delete(deleteId);
    }

    public void delete(T delete) {
        getRepository().delete(delete);
    }

}
