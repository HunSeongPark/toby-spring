package org.example.toby.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Hunseong-Park
 * @date : 2022-06-21
 */
public class UserDaoConnectionCountingTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = ctx.getBean("userDao", UserDao.class);

        CountingConnectionMaker ccm = ctx.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("count = " + ccm.getCount());
    }
}
