package slmp.moduel.services;

import java.util.List;
import java.util.Vector;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.Goods;
import slmp.moduel.services.intfc.GoodsSerIntfc;

public class GoodsSer implements GoodsSerIntfc {
	private BaseDAO dao;

	//查询所有物品
	@Override
	public List selectAll() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from goods where del_flag='0'");
		List list = dao.select(sql, 7, null);
		return list;
	}

	//增加物品
	@Override
	public void insert(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into goods(id,name,price,origin,stock,warehouse_id,category_id,del_flag)  values(?,?,?,?,?,?,?,'0')");
		dao.insert(sql, paraArray);

	}

	//根据id逻辑删除（修改del标识）物品
	@Override
	public void deleteByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update goods set del_flag='1' where id=?");
		dao.delete(sql, paraArray);

	}

	//根据id更新物品信息
	@Override
	public void updateByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update goods set name=?,price=?,origin=?,stock=?,warehouse_id=?,category_id=? where id=?");
		dao.update(sql, paraArray);

	}

	//根据id查询物品信息
	@Override
	public List selectByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from goods where id=?");
		List list = dao.select(sql, 7, paraArray);
		return list;
	}

	//根据条件查询物品信息
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
