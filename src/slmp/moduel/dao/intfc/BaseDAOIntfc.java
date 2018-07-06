package slmp.moduel.dao.intfc;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * ����DAO�ӿ�
 * @author Kevin
 *
 */

public interface BaseDAOIntfc {
	//��
	public void insert(String sql, Object[] paraArray) throws SQLException;
	
	//ɾ
	public void delete(String sql, Object[] paraArray) throws SQLException;
	
	//��
	public void update(String sql, Object[] paraArray) throws SQLException;
	
	//��
	public List select(String sql, int columnNum, Object[] paraArray) throws SQLException;
	
}
