package com.example;

import com.example.model.QUser;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void returnUserWhoseSalaryEqualOrLessThanFourThousand() {
        User jonathan = new User("Jonathan", 3530.20);
        testEntityManager.persist(jonathan);
        testEntityManager.flush();

        User maggie = new User("Maggie", 4300.50);
        testEntityManager.persist(maggie);
        testEntityManager.flush();

        BooleanExpression booleanExpression = QUser.user.salary.loe(4000.00);

        Iterable<User> result = userRepository.findAll(booleanExpression);
        User userRs = result.iterator().next();

        assertThat(userRs.getName()).isEqualToIgnoringCase(jonathan.getName());
    }

}
