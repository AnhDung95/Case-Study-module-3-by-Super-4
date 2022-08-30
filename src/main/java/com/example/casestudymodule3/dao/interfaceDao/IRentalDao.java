package com.example.casestudymodule3.dao.interfaceDao;

import com.example.casestudymodule3.dao.IGeneralDAO;
import com.example.casestudymodule3.model.Rental;

public interface IRentalDao extends IGeneralDAO<Rental> {
    default boolean add(Rental rental){
        return false;
    }
    boolean add(Rental rental, int idUser);
}
