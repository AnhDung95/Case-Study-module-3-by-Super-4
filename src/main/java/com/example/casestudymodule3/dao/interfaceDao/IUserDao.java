package com.example.casestudymodule3.dao.interfaceDao;

import com.example.casestudymodule3.dao.IGeneralDAO;
import com.example.casestudymodule3.model.Users;

public interface IUserDao extends IGeneralDAO<Users> {
    String findPassByAccount(String account, String email);
    boolean updateByUser(String account,Users users);
    int findByUser(Users users);
}
