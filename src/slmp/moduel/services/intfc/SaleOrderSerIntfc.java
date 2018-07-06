package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.SaleOrder;

public interface SaleOrderSerIntfc {
	//增加销售记录
	public void insert(Object[] paraArray) throws Exception;
	
	//查询所有销售记录
	public List selectAll() throws Exception;
	
	//根据条件查询销售记录
	public List selectByCondition(Object[] paraArray) throws Exception;
	
}
