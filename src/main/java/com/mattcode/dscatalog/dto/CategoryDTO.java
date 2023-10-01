package com.mattcode.dscatalog.dto;

import com.mattcode.dscatalog.entities.Category;

import java.io.Serial;
import java.io.Serializable;

public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public CategoryDTO(){

    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public CategoryDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }
}
