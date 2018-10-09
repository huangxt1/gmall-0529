package com.atguigu.gmall.user;

public interface UserService {
    /*
    * 获取用户
    * */
    public User getUser(String id);
    /*
    * 购买电影
    * uid:用户id
    * mid:电影id
    * */
    public void  buyMovie(String uid,String mid);
}
