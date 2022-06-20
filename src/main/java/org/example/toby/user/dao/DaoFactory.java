package org.example.toby.user.dao;

/**
 * @author : Hunseong-Park
 * @date : 2022-06-21
 */
public class DaoFactory {

    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
