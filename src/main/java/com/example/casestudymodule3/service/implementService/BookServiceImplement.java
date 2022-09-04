package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.dao.implementDao.BookDaoImplement;
import com.example.casestudymodule3.dao.interfaceDao.IBookDao;
import com.example.casestudymodule3.model.Book;
import com.example.casestudymodule3.service.interfaceService.IBookService;

import java.util.List;

public class BookServiceImplement implements IBookService {
    private final IBookDao bookDao = new BookDaoImplement();
//    public List<Book> findByPublishers(String publishers){
//        return bookDao.findByPublishers(publishers);
//    }

    @Override
    public List<Book> findByKeyword(String keyword) {
        return bookDao.findByKeyWord(keyword);
    }
    @Override
    public boolean update(int id, Book book, int idCategory, int idPublishers) {
        return bookDao.update(id,book,idCategory,idPublishers);
    }
    @Override
    public boolean add(Book book, int idCategory, int idPublishers) {
        return bookDao.add(book, idCategory, idPublishers);
    }

    @Override
    public List<Book> filter(String categoryName, String publishersName) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return bookDao.delete(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public boolean reduce(int quantity, int idBook) {
        return bookDao.reduce(quantity,idBook);
    }
}
