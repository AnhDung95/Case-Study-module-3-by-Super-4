package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.dao.implementDao.UsersDaoImplement;
import com.example.casestudymodule3.dao.interfaceDao.IUserDao;
import com.example.casestudymodule3.model.Users;
import com.example.casestudymodule3.service.interfaceService.IUsersService;

import java.util.List;

public class UsersServiceImplement implements IUsersService {
    private final IUserDao iUserDao = new UsersDaoImplement();

    @Override
    public List<Users> getAll() {
        return iUserDao.getAll();
    }

    @Override
    public boolean add(Users users) {
        return iUserDao.add(users);
    }

    @Override
    public boolean update(int id, Users users) {
        return iUserDao.update(id,users);
    }

    @Override
    public boolean delete(int id) {
        return iUserDao.delete(id);
    }

    @Override
    public Users findById(int id) {
        return iUserDao.findById(id);
    }

    @Override
    public String findPassByAccount(String account, String email) {
        return iUserDao.findPassByAccount(account,email);
    }

    @Override
    public boolean updateByUser(String account, Users users) {
        return iUserDao.updateByUser(account, users);
    }

    @Override
    public int findByUser(Users users) {
        return iUserDao.findByUser(users);
    }
}
