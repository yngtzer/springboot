package com.example.config;

import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class UserProcessor implements ItemProcessor<User, User> {

    private static final Logger log = LoggerFactory.getLogger(UserProcessor.class);

    @Override
    public User process(final User User) throws Exception {
        final String name = User.getName();
        final double salary = User.getSalary();

        final User transformedSalary = new User(name, salary);

        log.info("Converting (" + name + ", " + salary + ") into (" + transformedSalary + ")");

        return transformedSalary;
    }
}
