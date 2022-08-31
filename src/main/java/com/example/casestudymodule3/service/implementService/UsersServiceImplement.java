package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.model.Users;
import com.example.casestudymodule3.service.interfaceService.IUsersService;

import java.util.List;

public class UsersServiceImplement implements IUsersService {
    @Override
    public List<Users> getAll() {
            return null;
    }

    @Override
    public boolean add(Users users) {
        return false;
    }

    @Override
    public boolean update(int id, Users users) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Users findById(int id) {
        return null;
    }

    @Override
    public String findPassByAccount(String account, String email) {
        return null;
    }

    @Override
    public boolean updateByUser(String account, Users users) {
        return false;
    }

    @Override
    public int findByUser(Users users) {
        return 0;
    }
}
