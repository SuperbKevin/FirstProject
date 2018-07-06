package slmp.moduel.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;


/**
 * 
 * jdbc工具，用于获得数据库连接
 * @author Kevin
 *
 */

public class JdbcUtil {
	private String driver = null;
	private String url = null;
	private String user = null;
	private String password = null;
	private Properties prop = new Properties();
	private Connection conn = null;
	
	public JdbcUtil() {
		
		try {
			prop.load(Object.class.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("加载jdbc.properties配置文件异常");
			e.printStackTrace();
		}

		driver = prop.getProperty("jdbc.driver");
		url = prop.getProperty("jdbc.url");
		user = prop.getProperty("jdbc.username");
		password = prop.getProperty("jdbc.password");
		
		try {
			//加载驱动程序
			Class.forName(driver);
			
			//取得数据库连接
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//返回数据库连接
	public Connection getConnection() {
		return conn;
	}
	
	//释放数据库资源
	public void release(Object o) {
		if(o instanceof ResultSet) {
			try {
				((ResultSet) o).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(o instanceof PreparedStatement) {
			try {
				((PreparedStatement) o).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(o instanceof Connection) {
			try {
				((Connection) o).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//重写数据库资源释放
	public void release(ResultSet rs, PreparedStatement ps, Connection conn) {
		// TODO Auto-generated method stub
		release(rs);
		release(ps);
		release(conn);
	}
}
