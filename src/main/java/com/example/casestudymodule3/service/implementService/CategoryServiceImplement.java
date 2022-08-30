package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.dao.interfaceDao.ICategoryDao;
import com.example.casestudymodule3.model.Category;
import com.example.casestudymodule3.service.interfaceService.ICategoryService;

import java.util.List;

public class CategoryServiceImplement implements ICategoryService {
    private final ICategoryDao categoryDao = (ICategoryDao) new CategoryServiceImplement();
    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public boolean add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public boolean update(int id, Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Category findById(int id) {
        return null;
    }
}
