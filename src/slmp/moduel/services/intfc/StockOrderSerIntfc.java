package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.StockOrder;

public interface StockOrderSerIntfc {
	//查询所有入库单
	public List selectAllStockInput() throws Exception;
	
	// 根据条件查询入库单
	public List selectStockInputByCondition(Object[] paraArray) throws Exception;

	// 根据id逻辑删除出/入库单
	public void deleteStockById(Object[] paraArray) throws Exception;

	// 根据id更新出/入库单
	public void updateStockById(Object[] paraArray) throws Exception;

	// 增加入库单
	public void insertStockInput(Object[] paraArray) throws Exception;
	
	/*-------------------------------------------------------------------------------------------*/
	
	//查询所有出库单
	public List selectAllStockOutput() throws Exception;
	
	// 根据条件查询出库单
	public List selectStockOutputByCondition(Object[] paraArray) throws Exception;

	// 增加出库单
	public void insertStockOutput(Object[] paraArray) throws Exception;

}
