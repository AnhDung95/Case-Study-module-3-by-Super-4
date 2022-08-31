package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.dao.implementDao.RentalDaoImplement;
import com.example.casestudymodule3.dao.interfaceDao.IRentalDao;
import com.example.casestudymodule3.model.Rental;
import com.example.casestudymodule3.service.interfaceService.IRentalService;

import java.util.List;

public class RentalServiceImplement implements IRentalService {
    private final IRentalDao iRentalDao = new RentalDaoImplement();

    @Override
    public List<Rental> getAll() {
        return iRentalDao.getAll();
    }

    @Override
    public boolean add(Rental rental) {
        return false;
    }

    @Override
    public boolean update(int id, Rental rental) {
        return iRentalDao.update(id,rental);
    }

    @Override
    public boolean delete(int id) {
        return iRentalDao.delete(id);
    }

    @Override
    public Rental findById(int id) {
        return iRentalDao.findById(id);
    }

    @Override
    public boolean add(Rental rental, int idUser) {
        return iRentalDao.add(rental,idUser);
    }
}
