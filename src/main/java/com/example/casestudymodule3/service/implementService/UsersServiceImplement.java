package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.dao.UsersDaoImplement;
import com.example.casestudymodule3.dao.interfaceDao.IUserDao;
import com.example.casestudymodule3.model.Users;
import com.example.casestudymodule3.service.interfaceService.IUsersService;

import java.util.List;

public class UsersServiceImplement implements IUsersService {
    private final IUserDao usersDao = (IUserDao) new UsersDaoImplement();

    @Override
    public List<Users> getAll() {
        return usersDao.getAll();
    }

    @Override
    public boolean add(Users users) {
        return usersDao.add(users);
    }

    @Override
    public boolean update(int id, Users users) {
        return usersDao.update(id,users);
    }

    @Override
    public boolean delete(int id) {
        return usersDao.delete(id);
    }

    @Override
    public Users findById(int id) {
        return usersDao.findById(id);
    }

    @Override
    public String findPassByAccount(String account, String email) {
        return usersDao.findPassByAccount(account,email);
    }

    @Override
    public boolean updateByUser(String account, Users users) {
        return usersDao.updateByUser(account,users);
    }

    @Override
    public int findByUser(Users users) {
        return usersDao.findByUser(users);
    }
}

