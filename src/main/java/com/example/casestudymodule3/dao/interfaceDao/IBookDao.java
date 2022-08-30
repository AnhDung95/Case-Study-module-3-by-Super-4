package com.example.casestudymodule3.dao.interfaceDao;

import com.example.casestudymodule3.dao.IGeneralDAO;
import com.example.casestudymodule3.model.Book;

import java.util.List;

public interface IBookDao extends IGeneralDAO<Book> {
    List<Book> findByKeyWord(String keyword);

    @Override
    default boolean add(Book book) {
        return false;
    }

    @Override
    default boolean update(int id, Book book) {
        return false;
    }

    boolean add(Book book,int idCategory,int idPublishers);
    boolean update(int id, Book book,int categoryId,int publishersId);
    List<Book> filter(String categoryName,String publishersName);
    @Override
    List<Book> getAll();

    @Override
    boolean delete(int id);

    @Override
    Book findById(int id);
    boolean reduce(int quantity,int idBook);
}
