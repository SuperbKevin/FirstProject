package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.Warehouse;

public interface WarehousSerIntfc {
	//��ѯ���вֿ�
	public List selectAll() throws Exception;
	
	//���Ӳֿ�
	public void insert(Object[] paraArray) throws Exception;
	
	//����id�߼�ɾ���ֿ�
	public void deleteByID(Object[] paraArray) throws Exception;
	
	//����id�޸Ĳֿ���Ϣ
	public void updateByID(Object[] paraArray) throws Exception;
	
	//����id��ѯ�ֿ�
	public List selectByID(Object[] paraArray) throws Exception;
}
