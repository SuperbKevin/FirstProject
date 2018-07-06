package slmp.moduel.services;

import java.util.List;
import java.util.Vector;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.Goods;
import slmp.moduel.entity.SaleOrder;
import slmp.moduel.services.intfc.SaleOrderSerIntfc;

public class SaleOrderSer implements SaleOrderSerIntfc {
	private BaseDAO dao;

	//�������ۼ�¼
	@Override
	public void insert(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into sale_order(id,bill_no,handler_id,category_id,warehouse_id,amount,goods_id,del_flag)  values(?,?,?,?,?,?,?,'0')");
		dao.insert(sql, paraArray);

	}

	//��ѯ�������ۼ�¼
	@Override
	public List selectAll() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from sale_order where del_flag='0'");
		List list = dao.select(sql, 7, null);
		return list;
	}

	//����������ѯ���ۼ�¼
	@Override
	public List selectByCondition(Object[] paraArray) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
