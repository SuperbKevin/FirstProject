package slmp.moduel.services;

import java.util.ArrayList;
import java.util.List;

import slmp.moduel.dao.BaseDAO;
import slmp.moduel.entity.Category;
import slmp.moduel.services.intfc.CategorySerIntfc;

public class CategorySer implements CategorySerIntfc {

	//查询所有分裂
	@Override
	public List selectAll() throws Exception {
		BaseDAO dao = new BaseDAO();
		String sql = new String("select * from category where del_flag='0'");
		List list = dao.select(sql, 2, null);
		return list;
	}

	@Override
	public List selectByID(Object[] paraArray) throws Exception {
		BaseDAO dao = new BaseDAO();
		String sql = new String("select * from category where id=?");
		List list = dao.select(sql, 2, paraArray);
		return list;
	}

}
