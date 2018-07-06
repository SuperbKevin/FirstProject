package slmp.moduel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import slmp.moduel.dao.intfc.BaseDAOIntfc;
import slmp.moduel.db.JdbcUtil;

/**
 * 
 * 基础DAO实现
 * @author Kevin
 *
 */
public class BaseDAO implements BaseDAOIntfc {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private JdbcUtil jdbc;

	public BaseDAO() {
		super();
		jdbc = new JdbcUtil();
		conn = jdbc.getConnection();
	}

	@Override//重写增加
	public void insert(String sql, Object[] paraArray) throws SQLException {
		// TODO Auto-generated method stub
		ps = conn.prepareStatement(sql);
		for (int i = 0; i < paraArray.length; i++) {
			ps.setObject(i+1, paraArray[i]);
		}
		ps.executeUpdate();
		jdbc.release(rs, ps, conn);
	}

	@Override//重写删除
	public void delete(String sql, Object[] paraArray) throws SQLException {
		// TODO Auto-generated method stub
		ps = conn.prepareStatement(sql);
		for (int i = 0; i < paraArray.length; i++) {
			ps.setObject(i+1, paraArray[i]);
		}
		ps.executeUpdate();
		jdbc.release(rs, ps, conn);
	}

	@Override//重写更新（更改）
	public void update(String sql, Object[] paraArray) throws SQLException {
		// TODO Auto-generated method stub
		ps = conn.prepareStatement(sql);
		for (int i = 0; i < paraArray.length; i++) {
			ps.setObject(i+1, paraArray[i]);
		}
		ps.executeUpdate();
		jdbc.release(rs, ps, conn);
	}

	@Override//重写查询（读）
	public List select(String sql, int columnNum, Object[] paraArray) throws SQLException {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		
		ps = conn.prepareStatement(sql);
		if(paraArray != null) {
			for (int i = 0; i < paraArray.length; i++) {
				ps.setObject(i+1, paraArray[i]);
			}
		}
		rs = ps.executeQuery();
		//根据不同实体对象属性表长度不同进行读取
		while(rs.next()) {
			Object[] array = new Object[columnNum];
			for(int i=0; i < columnNum; i++) {
				array[i] = rs.getObject(i+1);
			}
			list.add(array);
		}
		jdbc.release(rs, ps, conn);
		return list;
	}

}
