package slmp.moduel.dao.intfc;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * 基础DAO接口
 * @author Kevin
 *
 */

public interface BaseDAOIntfc {
	//增
	public void insert(String sql, Object[] paraArray) throws SQLException;
	
	//删
	public void delete(String sql, Object[] paraArray) throws SQLException;
	
	//改
	public void update(String sql, Object[] paraArray) throws SQLException;
	
	//查
	public List select(String sql, int columnNum, Object[] paraArray) throws SQLException;
	
}
