package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.Warehouse;

public interface WarehousSerIntfc {
	//查询所有仓库
	public List selectAll() throws Exception;
	
	//增加仓库
	public void insert(Object[] paraArray) throws Exception;
	
	//根据id逻辑删除仓库
	public void deleteByID(Object[] paraArray) throws Exception;
	
	//根据id修改仓库信息
	public void updateByID(Object[] paraArray) throws Exception;
	
	//根据id查询仓库
	public List selectByID(Object[] paraArray) throws Exception;
}
