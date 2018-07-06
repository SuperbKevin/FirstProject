package slmp.assembly;

import java.util.UUID;

public class IDGenerator {
	
	//自动生成32位id
	public static String generateID() {
		UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String temp = str.substring(0, 8) + str.substring(9, 13)  
        + str.substring(14, 18) + str.substring(19, 23)  
        + str.substring(24);
        String uuidStr=temp.replace("-", "");
        return uuidStr;
	}

}
