package com.example.casestudymodule3.service.interfaceService;

import com.example.casestudymodule3.model.Users;
import com.example.casestudymodule3.service.IGeneralService;

public interface IUsersService extends IGeneralService<Users> {
    boolean add(Users users, int Id);

    String findPassByAccount(String account,String email);
    boolean updateByUser(String account,Users users);
    int findByUser(Users users);
}
