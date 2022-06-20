package org.example.toby.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : Hunseong-Park
 * @date : 2022-06-21
 */
public interface ConnectionMaker {
    Connection makeConnection() throws ClassNotFoundException, SQLException;
}
