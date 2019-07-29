package cn.Travle.IUser;

import cn.Travel.vo.CosumerLogin;
import cn.Travel.vo.User;
import cn.Travel.vo.consumer;

public interface IConsumerlogin {
	public boolean login(CosumerLogin vo)throws Exception;
	public Integer add(CosumerLogin vo);
	public Integer add1(CosumerLogin vo);
}
