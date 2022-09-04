package com.example.casestudymodule3.service.interfaceService;

import com.example.casestudymodule3.model.Book;
import com.example.casestudymodule3.service.IGeneralService;

import java.util.List;

public interface IBookService extends IGeneralService<Book> {

    @Override
    default boolean add(Book book) {
        return false;
    }

    @Override
    default boolean update(int id, Book book) {
        return false;
    }

    List<Book> findByKeyword(String keyword);

    boolean update(int id, Book book, int idCategory, int idPublishers);

    boolean add(Book book , int idCategory,int idPublishers);
    List<Book> filter(String categoryName,String publishersName);

    @Override
    boolean delete(int id);

    @Override
    List<Book> getAll();

    @Override
    Book findById(int id);
    boolean reduce(int quantity, int idBook);
}
