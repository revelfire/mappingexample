package com.revelfire.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by cmathias on 2/4/16.
 */
@MappedSuperclass
public abstract class Identifiable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //This is an incremental

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
