package slmp.moduel.services;

import java.util.List;
import java.util.Vector;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.Goods;
import slmp.moduel.entity.StockOrder;
import slmp.moduel.services.intfc.StockOrderSerIntfc;

public class StockOrderSer implements StockOrderSerIntfc {
	private BaseDAO dao;
	
	//��ѯ������ⵥ
	@Override
	public List selectAllStockInput() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from stock_order where sign='0' and del_flag='0'");
		List list = dao.select(sql, 7, null);
		return list;
	}

	// ����������ѯ��ⵥ
	@Override
	public List selectStockInputByCondition(Object[] paraArray) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// ����id�߼�ɾ����/��ⵥ
	@Override
	public void deleteStockById(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update stock_order set del_flag='1' where id=?");
		dao.update(sql, paraArray);
	}

	// ����id���³�/��ⵥ
	@Override
	public void updateStockById(Object[] paraArray) throws Exception {
		// TODO Auto-generated method stub

	}

	// ������ⵥ
	@Override
	public void insertStockInput(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into stock_order(id,bill_no,handler_id,warehouse_id,category_id,amount,goods_id,sign,del_flag)  values(?,?,?,?,?,?,?,'0','0')");
		dao.insert(sql, paraArray);
	}
	
	/*-------------------------------------------------------------------------------------------*/

	//��ѯ���г��ⵥ
	@Override
	public List selectAllStockOutput() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from stock_order where sign='1' and del_flag='0'");
		List list = dao.select(sql, 7, null);
		return list;
	}

	// ����������ѯ���ⵥ
	@Override
	public List selectStockOutputByCondition(Object[] paraArray) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// ���ӳ��ⵥ
	@Override
	public void insertStockOutput(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into stock_order(id,bill_no,handler_id,warehouse_id,category_id,amount,goods_id,sign,del_flag)  values(?,?,?,?,?,?,?,'1','0')");
		dao.insert(sql, paraArray);
	}

}
