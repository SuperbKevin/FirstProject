package slmp.moduel.services;

import java.util.List;
import java.util.Vector;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.Goods;
import slmp.moduel.entity.StockOrder;
import slmp.moduel.services.intfc.StockOrderSerIntfc;

public class StockOrderSer implements StockOrderSerIntfc {
	private BaseDAO dao;
	
	//查询所有入库单
	@Override
	public List selectAllStockInput() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from stock_order where sign='0' and del_flag='0'");
		List list = dao.select(sql, 7, null);
		return list;
	}

	// 根据条件查询入库单
	@Override
	public List selectStockInputByCondition(Object[] paraArray) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 根据id逻辑删除出/入库单
	@Override
	public void deleteStockById(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update stock_order set del_flag='1' where id=?");
		dao.update(sql, paraArray);
	}

	// 根据id更新出/入库单
	@Override
	public void updateStockById(Object[] paraArray) throws Exception {
		// TODO Auto-generated method stub

	}

	// 增加入库单
	@Override
	public void insertStockInput(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into stock_order(id,bill_no,handler_id,warehouse_id,category_id,amount,goods_id,sign,del_flag)  values(?,?,?,?,?,?,?,'0','0')");
		dao.insert(sql, paraArray);
	}
	
	/*-------------------------------------------------------------------------------------------*/

	//查询所有出库单
	@Override
	public List selectAllStockOutput() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from stock_order where sign='1' and del_flag='0'");
		List list = dao.select(sql, 7, null);
		return list;
	}

	// 根据条件查询出库单
	@Override
	public List selectStockOutputByCondition(Object[] paraArray) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 增加出库单
	@Override
	public void insertStockOutput(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into stock_order(id,bill_no,handler_id,warehouse_id,category_id,amount,goods_id,sign,del_flag)  values(?,?,?,?,?,?,?,'1','0')");
		dao.insert(sql, paraArray);
	}

}
