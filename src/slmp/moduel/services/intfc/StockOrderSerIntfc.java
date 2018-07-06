package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.StockOrder;

public interface StockOrderSerIntfc {
	//��ѯ������ⵥ
	public List selectAllStockInput() throws Exception;
	
	// ����������ѯ��ⵥ
	public List selectStockInputByCondition(Object[] paraArray) throws Exception;

	// ����id�߼�ɾ����/��ⵥ
	public void deleteStockById(Object[] paraArray) throws Exception;

	// ����id���³�/��ⵥ
	public void updateStockById(Object[] paraArray) throws Exception;

	// ������ⵥ
	public void insertStockInput(Object[] paraArray) throws Exception;
	
	/*-------------------------------------------------------------------------------------------*/
	
	//��ѯ���г��ⵥ
	public List selectAllStockOutput() throws Exception;
	
	// ����������ѯ���ⵥ
	public List selectStockOutputByCondition(Object[] paraArray) throws Exception;

	// ���ӳ��ⵥ
	public void insertStockOutput(Object[] paraArray) throws Exception;

}
