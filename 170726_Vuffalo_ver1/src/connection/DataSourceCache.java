package connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceCache {
	private static DataSourceCache instance;
	private DataSource dataSource;
	static{
		instance = new DataSourceCache();
	}
	
	private DataSourceCache(){
		Context context = null;
		try {
			context = new InitialContext();
			//dataSource = (DataSource) context.lookup("java:comp/env/jdbc/TestDB");
			Context envContext = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/TestDB");
			//dataSource = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e){
			System.out.println("DataSourceCache.java: lookup ¿À·ù");
			e.printStackTrace();
		}
	}
	
	public static DataSourceCache getInstance(){
		return instance;
	}
	public DataSource getDataSource(){
		return dataSource;
	}
}
