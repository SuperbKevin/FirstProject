package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.Goods;

public interface GoodsSerIntfc {
	//��ѯ������Ʒ
	public List selectAll() throws Exception; 
	
	//������Ʒ
	public void insert(Object[] paraArray) throws Exception;
	
	//����id�߼�ɾ�����޸�del��ʶ����Ʒ
	public void deleteByID(Object[] paraArray) throws Exception;
	
	//����id������Ʒ��Ϣ
	public void updateByID(Object[] paraArray) throws Exception;
	
	//����id��ѯ��Ʒ��Ϣ
	public List selectByID(Object[] paraArray) throws Exception;
	
	//����������ѯ��Ʒ��Ϣ
	public List selectByCondition(Object[] paraArray) throws Exception;
	
	//����id�޸���Ʒ���
	public void updateStockByID(Object[] paraArray) throws Exception;

}
