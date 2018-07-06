package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.User;

public interface UserSerIntfc {
	//添加用户
	public void insert(Object[] paraArray) throws Exception;
	
	//根据ID修改用户信息
	public void updateByID(Object[] paraArray) throws Exception;
	
	//根据账号获取一个用户
	public User selectOneUser(Object[] paraArray) throws Exception;
	
	//根据id获取用户名
	public List selectByID(Object[] paraArray) throws Exception;
	
}
