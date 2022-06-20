package org.example.toby.user.dao;

import org.example.toby.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * @author : Hunseong-Park
 * @date : 2022-06-21
 */
public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = ctx.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("hunseong12");
        user.setName("훈성");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 생성");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회");
    }
}
