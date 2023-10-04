package com.mattcode.dscatalog.dto;

import com.mattcode.dscatalog.entities.Category;
import com.mattcode.dscatalog.entities.Product;
import jakarta.persistence.Column;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Instant date;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(){

    }

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl, Instant date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.imgUrl = entity.getImgUrl();
        this.date = entity.getDate();
    }

    public ProductDTO(Product entity, Set<Category> categories){
        this(entity);
        categories.forEach(x -> this.categories.add(new CategoryDTO(x)));
    }

    public Long getId() {
        return id;
    }

    public ProductDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ProductDTO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public ProductDTO setDate(Instant date) {
        this.date = date;
        return this;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }


}
