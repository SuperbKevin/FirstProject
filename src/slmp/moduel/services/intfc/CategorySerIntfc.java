package slmp.moduel.services.intfc;

import java.util.List;

import slmp.moduel.entity.Category;

public interface CategorySerIntfc {
	//��ѯ���з���
	public List selectAll() throws Exception;
	
	//����id��ѯ
	public List selectByID(Object[] paraArray) throws Exception;

}
