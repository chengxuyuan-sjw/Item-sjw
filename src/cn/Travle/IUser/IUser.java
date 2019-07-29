package cn.Travle.IUser;

import java.util.List;

import cn.Travel.vo.User;

public interface IUser {
    public boolean findLogin(User vo)throws Exception;
    public Integer add(User vo)throws Exception;
    public Integer update(User obj)throws Exception;
    public List<User> queryAll()throws Exception;
    public User queryObject(String vo)throws Exception;
}
