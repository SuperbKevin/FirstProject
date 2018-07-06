package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.Category;

public interface CategorySerIntfc {
	//查询所有分类
	public List selectAll() throws Exception;
	
	//根据id查询
	public List selectByID(Object[] paraArray) throws Exception;

}
