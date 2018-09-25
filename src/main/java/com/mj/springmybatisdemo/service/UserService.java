package com.mj.springmybatisdemo.service;

import com.mj.springmybatisdemo.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

}
