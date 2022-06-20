package org.example.toby.user.dao;

import org.example.toby.user.domain.User;

import java.sql.SQLException;

/**
 * @author : Hunseong-Park
 * @date : 2022-06-21
 */
public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DaoFactory daoFactory = new DaoFactory();
        UserDao dao = daoFactory.userDao();

        User user = new User();
        user.setId("hunseong1");
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
