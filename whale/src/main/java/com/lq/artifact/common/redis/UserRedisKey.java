package com.lq.artifact.common.redis;

public class UserRedisKey {
    /**
     * 用户登录后保存用户信息key
     */
    private final static String USER_LOGIN_INFO_KEY = "user:";

    /**
     * 获取登录信息key
     * @param id
     * @return
     */
    public static String getUserLoginKey(Long id){
        return USER_LOGIN_INFO_KEY + "login:";
    }
}
