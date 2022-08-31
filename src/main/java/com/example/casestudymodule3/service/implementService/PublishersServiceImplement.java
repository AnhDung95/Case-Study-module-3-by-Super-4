package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.dao.implementDao.PublishersDaoImplement;
import com.example.casestudymodule3.dao.interfaceDao.IPublishersDao;
import com.example.casestudymodule3.model.Publishers;
import com.example.casestudymodule3.service.interfaceService.IPublishersService;

import java.util.List;

public class PublishersServiceImplement implements IPublishersService {
private final IPublishersDao iPublishersDao = new PublishersDaoImplement();
    @Override
    public List<Publishers> getAll() {
        return iPublishersDao.getAll();
    }

    @Override
    public boolean add(Publishers publishers) {
        return iPublishersDao.add(publishers);
    }

    @Override
    public boolean update(int id, Publishers publishers) {
        return iPublishersDao.update(id, publishers);
    }

    @Override
    public boolean delete(int id) {
        return iPublishersDao.delete(id);
    }

    @Override
    public Publishers findById(int id) {
        return iPublishersDao.findById(id);
    }
}
