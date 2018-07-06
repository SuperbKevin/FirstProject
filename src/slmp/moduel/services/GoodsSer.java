package slmp.moduel.services;

import java.util.List;
import java.util.Vector;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.Goods;
import slmp.moduel.services.intfc.GoodsSerIntfc;

public class GoodsSer implements GoodsSerIntfc {
	private BaseDAO dao;

	//��ѯ������Ʒ
	@Override
	public List selectAll() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from goods where del_flag='0'");
		List list = dao.select(sql, 7, null);
		return list;
	}

	//������Ʒ
	@Override
	public void insert(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into goods(id,name,price,origin,stock,warehouse_id,category_id,del_flag)  values(?,?,?,?,?,?,?,'0')");
		dao.insert(sql, paraArray);

	}

	//����id�߼�ɾ�����޸�del��ʶ����Ʒ
	@Override
	public void deleteByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update goods set del_flag='1' where id=?");
		dao.delete(sql, paraArray);

	}

	//����id������Ʒ��Ϣ
	@Override
	public void updateByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update goods set name=?,price=?,origin=?,stock=?,warehouse_id=?,category_id=? where id=?");
		dao.update(sql, paraArray);

	}

	//����id��ѯ��Ʒ��Ϣ
	@Override
	public List selectByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from goods where id=?");
		List list = dao.select(sql, 7, paraArray);
		return list;
	}

	//����������ѯ��Ʒ��Ϣ
	@Override
	public List selectByCondition(Object[] paraArray) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStockByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update goods set stock=? where id=?");
		dao.update(sql, paraArray);
		
	}

}
