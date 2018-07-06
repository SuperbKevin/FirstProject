package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.Goods;

public interface GoodsSerIntfc {
	//查询所有物品
	public List selectAll() throws Exception; 
	
	//增加物品
	public void insert(Object[] paraArray) throws Exception;
	
	//根据id逻辑删除（修改del标识）物品
	public void deleteByID(Object[] paraArray) throws Exception;
	
	//根据id更新物品信息
	public void updateByID(Object[] paraArray) throws Exception;
	
	//根据id查询物品信息
	public List selectByID(Object[] paraArray) throws Exception;
	
	//根据条件查询物品信息
	public List selectByCondition(Object[] paraArray) throws Exception;
	
	//根据id修改物品库存
	public void updateStockByID(Object[] paraArray) throws Exception;

}
