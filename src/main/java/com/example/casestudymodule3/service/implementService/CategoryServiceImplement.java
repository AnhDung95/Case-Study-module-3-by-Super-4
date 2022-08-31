package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.dao.implementDao.CategoryDaoImplement;
import com.example.casestudymodule3.dao.interfaceDao.ICategoryDao;
import com.example.casestudymodule3.model.Category;
import com.example.casestudymodule3.service.interfaceService.ICategoryService;

import java.util.List;

public class CategoryServiceImplement implements ICategoryService {
    private final ICategoryDao categoryDao = new CategoryDaoImplement();
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
        return categoryDao.update(id, category);
    }

    @Override
    public boolean delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }
}
