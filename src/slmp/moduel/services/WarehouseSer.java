package slmp.moduel.services;

import java.util.List;
import java.util.Vector;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.StockOrder;
import slmp.moduel.entity.Warehouse;
import slmp.moduel.services.intfc.WarehousSerIntfc;

public class WarehouseSer implements WarehousSerIntfc {
	private BaseDAO dao;

	//��ѯ���вֿ�
	@Override
	public List selectAll() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from warehouse where del_flag='0'");
		List list = dao.select(sql, 4, null);
		return list;
	}

	//���Ӳֿ�
	@Override
	public void insert(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into warehouse(id,name,del_flag,sort)  values(?,?,'0',?)");
		dao.insert(sql, paraArray);
	}

	//����id�߼�ɾ���ֿ�
	@Override
	public void deleteByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update warehouse set del_flag='1' where id=?");
		dao.update(sql, paraArray);
	}

	//����id�޸Ĳֿ���Ϣ
	@Override
	public void updateByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update warehouse set name=? where id=?");
		dao.update(sql, paraArray);
	}

	@Override
	public List selectByID(Object[] paraArray) throws Exception {
		BaseDAO dao = new BaseDAO();
		String sql = new String("select * from warehouse where id=?");
		List list = dao.select(sql, 4, paraArray);
		return list;
	}

}
