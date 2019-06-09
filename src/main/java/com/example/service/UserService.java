package com.example.service;

import com.example.model.QUser;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getEmployeeWhoseSalaryEqualOrLessThanFourThousand() {
        BooleanExpression lessThanOrEqualTo = QUser.user.salary.loe(4000.00);
        BooleanExpression moreThanOrEqualTo = QUser.user.salary.goe(0.00);
        Iterable<User> results = this.userRepository.findAll(lessThanOrEqualTo.and(moreThanOrEqualTo));
        List<User> collection = new ArrayList<>();
        results.forEach(collection::add);
        return collection;
    }
}
