package slmp.moduel.services;

import java.util.ArrayList;
import java.util.List;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.User;
import slmp.moduel.services.intfc.UserSerIntfc;

public class UserSer implements UserSerIntfc {
	private BaseDAO dao;

	//添加用户
	@Override
	public void insert(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("inert into user(id,name,password,identity) value(?,?,?,?)");
		dao.insert(sql, paraArray);

	}

	//根据账号密码修改用户信息
	@Override
	public void updateByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update user set name=?,password=? where id=?");
		dao.update(sql, paraArray);

	}

	//根据账号获取一个用户
	@Override
	public User selectOneUser(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		User user = null;
		List list = new ArrayList();
		String sql = new String("select id,name,password,identity from user where name=?");
		list = dao.select(sql, 4, paraArray);
		if(!list.isEmpty()) {
			user = new User();
			user.setId( (String) ((Object[])list.get(0))[0] );
			user.setName( (String) ((Object[])list.get(0))[1] );
			user.setPassword( (String) ((Object[])list.get(0))[2] );
			user.setIdentity( (String) ((Object[])list.get(0))[3] );
		}
		return user;
	}

	@Override
	public List selectByID(Object[] paraArray) throws Exception {
		BaseDAO dao = new BaseDAO();
		String sql = new String("select * from user where id=?");
		List list = dao.select(sql, 3, paraArray);
		return list;
	}

}
