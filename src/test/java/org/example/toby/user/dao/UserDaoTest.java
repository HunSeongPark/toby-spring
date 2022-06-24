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
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        User user = new User("hunseong2", "박훈성", "1234");

        // when
        dao.add(user);
        User findUser = dao.get(user.getId());

        // then
        assertThat(findUser.getName()).isEqualTo(user.getName());
        assertThat(findUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(dao.getCount()).isEqualTo(1);
    }

    @Test
    void count() throws SQLException {

        // given
        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("a", "aa", "aaa");
        User user2 = new User("b", "bb", "bbb");
        User user3 = new User("c", "cc", "ccc");

        // when & then
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);
    }
}