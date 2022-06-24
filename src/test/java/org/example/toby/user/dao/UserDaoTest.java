package org.example.toby.user.dao;

import org.example.toby.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : Hunseong-Park
 * @date : 2022-06-24
 */
class UserDaoTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

    @Test
    void addAndGet() throws SQLException {

        // given
        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("hunseong2");
        user.setName("박훈성");
        user.setPassword("1234");

        // when
        dao.add(user);
        User findUser = dao.get(user.getId());

        // then
        assertThat(findUser.getName()).isEqualTo(user.getName());
        assertThat(findUser.getPassword()).isEqualTo(user.getPassword());
    }
}