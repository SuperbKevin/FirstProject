package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.User;

public interface UserSerIntfc {
	//����û�
	public void insert(Object[] paraArray) throws Exception;
	
	//����ID�޸��û���Ϣ
	public void updateByID(Object[] paraArray) throws Exception;
	
	//�����˺Ż�ȡһ���û�
	public User selectOneUser(Object[] paraArray) throws Exception;
	
	//����id��ȡ�û���
	public List selectByID(Object[] paraArray) throws Exception;
	
}
