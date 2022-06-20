package org.example.toby.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : Hunseong-Park
 * @date : 2022-06-21
 */
public class CountingConnectionMaker implements ConnectionMaker {
    int count;
    ConnectionMaker realConnectionMaker;

    public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        count++;
        return realConnectionMaker.makeConnection();
    }

    public int getCount() {
        return this.count;
    }
}
