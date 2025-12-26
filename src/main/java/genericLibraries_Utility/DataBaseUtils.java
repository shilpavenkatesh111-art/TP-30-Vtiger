package genericLibraries_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtils {
	Connection conn= null;
	ResultSet result = null;
	
	/**
	 * @author Srinivas V
	 * this method is used to register the database
	 * @throws SQLException
	 */
public void  connectToDB() throws SQLException
{
	//register the database
	Driver driver= new Driver();
	DriverManager.registerDriver(driver);
	
	//get connection for database
	conn = DriverManager.getConnection(IpathConstants.dbURL, IpathConstants.dbUserName, IpathConstants.dbPassword);
}
/**
 * this method is used to create statement
 * @param query
 * @return
 * @throws SQLException
 */
	public ResultSet executeQuery(String query) throws SQLException
	{
		//create statement
		Statement state=conn.createStatement();
		
		//execute query
		result=state.executeQuery(query);
		return result;
	}
	
	/**
	 * this method is used to create statement
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int updateQuery(String query) throws SQLException {
		
		//create statement
		Statement state=conn.createStatement();
		int res=state.executeUpdate(query);
		return res;
		
	}
	
	/**
	 * this method is used to disconnect the connection
	 * @author Srinivas V
	 * this method is used to close the connection
	 * @throws SQLException
	 */
	public void disconnetDB() throws SQLException
	{
		//close the connection
		conn.close();
	}
	
}
