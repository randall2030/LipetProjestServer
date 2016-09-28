package com.envcheck.base.dynamic_change_datasource;

import com.envcheck.base.user.bean.User;

/**
 * Created by susion on 2016/6/24.
 */
public class UserContextHolder {

    private static final ThreadLocal contextHolder = new ThreadLocal();

    public static User getCurrentUser() {
        return (User) contextHolder.get();
    }

    public static void setCurrentUser(User userName) {
        contextHolder.set(userName);

    }
}
