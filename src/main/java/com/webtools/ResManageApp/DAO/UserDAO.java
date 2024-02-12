package com.webtools.ResManageApp.DAO;

import com.webtools.ResManageApp.pojo.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

@Component
public class UserDAO extends DAO {

    public User getUser(String username, String password) {
        User user = null;
        boolean isUserExist = false;
        try {
            Query q = getSession().createQuery("from User where name= :username and Password= :password");
            q.setString("username", username);
            q.setString("password", password);
            user = (User) q.uniqueResult();
//            if(user != null) {
//                isUserExist = true;
//            } else {
//                isUserExist = false;
//            }
            System.out.println(user.getType() + " in DAO");
//        User user = getSession().get(User.class, userid);
        } catch (Exception E) {
            
            System.out.println(E);
        }
        return user;

    }

    public void addUser(User user) {
        try {
            begin();
            getSession().save(user);
            commit();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}