package slmp.moduel.services;

import java.util.List;
import java.util.Vector;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.StockOrder;
import slmp.moduel.entity.Warehouse;
import slmp.moduel.services.intfc.WarehousSerIntfc;

public class WarehouseSer implements WarehousSerIntfc {
	private BaseDAO dao;

	//查询所有仓库
	@Override
	public List selectAll() throws Exception {
		dao = new BaseDAO();
		String sql = new String("select * from warehouse where del_flag='0'");
		List list = dao.select(sql, 4, null);
		return list;
	}

	//增加仓库
	@Override
	public void insert(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("insert into warehouse(id,name,del_flag,sort)  values(?,?,'0',?)");
		dao.insert(sql, paraArray);
	}

	//根据id逻辑删除仓库
	@Override
	public void deleteByID(Object[] paraArray) throws Exception {
		dao = new BaseDAO();
		String sql = new String("update warehouse set del_flag='1' where id=?");
		dao.update(sql, paraArray);
	}

	//根据id修改仓库信息
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
