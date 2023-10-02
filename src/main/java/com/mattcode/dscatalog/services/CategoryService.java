package com.mattcode.dscatalog.services;

import com.mattcode.dscatalog.dto.CategoryDTO;
import com.mattcode.dscatalog.entities.Category;
import com.mattcode.dscatalog.repositories.CategoryRepository;
import com.mattcode.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();
       return list.stream().map(CategoryDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id){
        Optional<Category> category = repository.findById(id);
        Category entity = category.orElseThrow(()-> new EntityNotFoundException("Entity not found"));
        return new CategoryDTO(entity);

    }

    @Transactional(readOnly = true)
    public CategoryDTO insert(CategoryDTO category) {
        Category entity = new Category();
        entity.setName(category.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }
}
