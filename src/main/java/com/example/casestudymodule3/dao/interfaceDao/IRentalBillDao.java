package com.example.casestudymodule3.dao.interfaceDao;

import com.example.casestudymodule3.dao.IGeneralDAO;
import com.example.casestudymodule3.model.RentalBill;

import java.util.List;

public interface IRentalBillDao extends IGeneralDAO<RentalBill> {
    List<RentalBill> getRentalBillByIdRental(int idRetal);
}
