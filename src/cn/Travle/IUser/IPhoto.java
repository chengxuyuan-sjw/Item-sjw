package cn.Travle.IUser;

import java.util.List;

import cn.Travel.vo.Photo;

public interface IPhoto {
    public List<Photo> find()throws Exception;
    public Integer insert(Photo vo)throws Exception;
    public Integer delete(Photo vo)throws Exception;
    public Integer updata(Photo vo)throws Exception;
    public String findbyid(String id)throws Exception;
}
