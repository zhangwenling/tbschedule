package com.free.tbschedule.demo.task.service.impl;

import com.free.tbschedule.demo.task.dto.User;
import com.free.tbschedule.demo.task.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsers(int mod, List<Integer> remainder, int topNum) {
        return UserDao.getAllUsers();
    }

    @Override
    public int update(User task) {
        return 1;
    }

    static class UserDao {

        private static AtomicInteger idCount = new AtomicInteger(0);

        /**
         * 模拟持久层，从数据库取数据
         */
        private synchronized static List<User> getAllUsers() {
            ArrayList<User> users = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                users.add(new User(idCount.incrementAndGet(), "LiLi", 43));
                log.info("idCount====》》{}", idCount.get());
            }
            return users;
        }
    }
}
