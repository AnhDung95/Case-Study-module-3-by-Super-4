package com.example.casestudymodule3.service.interfaceService;

import com.example.casestudymodule3.model.Rental;
import com.example.casestudymodule3.service.IGeneralService;

public interface IRentalService extends IGeneralService<Rental> {
    boolean add(Rental rental , int idUser);
}
