package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.SaleOrder;

public interface SaleOrderSerIntfc {
	//�������ۼ�¼
	public void insert(Object[] paraArray) throws Exception;
	
	//��ѯ�������ۼ�¼
	public List selectAll() throws Exception;
	
	//����������ѯ���ۼ�¼
	public List selectByCondition(Object[] paraArray) throws Exception;
	
}
