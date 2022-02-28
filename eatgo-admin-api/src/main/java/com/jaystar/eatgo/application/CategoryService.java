package com.jaystar.eatgo.application;

import com.jaystar.eatgo.domain.Category;
import com.jaystar.eatgo.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category addCategory(String name) {
        Category category = Category.builder()
                .name(name)
                .build();

        categoryRepository.save(category);

        return category;
    }
}
