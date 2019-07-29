package cn.Travle.IUser;

import java.util.List;

import cn.Travel.vo.consumer;

public interface IConsumer {
       public List<consumer> find(Object vo)throws Exception;
       public int insert(consumer vo)throws Exception;
       public int count(Object vo)throws Exception;
       public List<consumer> all(consumer vo)throws Exception;
       public List<consumer> Limit(consumer vo)throws Exception;
}
