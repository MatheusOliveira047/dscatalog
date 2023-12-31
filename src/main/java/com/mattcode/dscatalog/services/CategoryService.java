package com.mattcode.dscatalog.services;

import com.mattcode.dscatalog.dto.CategoryDTO;
import com.mattcode.dscatalog.entities.Category;
import com.mattcode.dscatalog.repositories.CategoryRepository;
import com.mattcode.dscatalog.services.exceptions.DatabaseException;
import com.mattcode.dscatalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest pageRequest){
        Page<Category> list = repository.findAll(pageRequest);

       return list.map(CategoryDTO::new);
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id){
        Optional<Category> category = repository.findById(id);
        Category entity = category.orElseThrow(()-> new ResourceNotFoundException("Entity não encotrada"));
        return new CategoryDTO(entity);

    }

    @Transactional
    public CategoryDTO insert(CategoryDTO category) {
        Category entity = new Category();
        entity.setName(category.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO category) {
        try {
            Category entity = repository.getReferenceById(id);
            entity.setName(category.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }
}
