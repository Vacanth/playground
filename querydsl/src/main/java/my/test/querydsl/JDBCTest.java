package my.test.querydsl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class JDBCTest {
		   // JDBC driver name and database URL
		   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   private static final String DB_URL = "jdbc:mysql://ec2-54-234-99-88.compute-1.amazonaws.com:3306/invdb";
		   private static final int LOAD_COUNT = 5000;

		   //  Database credentials
		   static final String USER = "user5";
		   static final String PASS = "password";
		   
		   public static void main(String[] args) throws SQLException, ClassNotFoundException {
			   Connection conn = null;
			   try{
			      //Register JDBC driver
			      Class.forName(JDBC_DRIVER);
	
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      log("%%%%%%%%% PLAIN JDBC TESTS %%%%%%%");
	
			      insertAccounts(conn);
			      
			      updateAccounts(conn);

			      findAccounts(conn);
			      
			      deleteAccounts(conn);
			   } finally {
		            conn.close();
			   }
			      
		}
		
		   
		private static void deleteAccounts(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			try {
				log("DELETE LOAD TEST FOR PLAIN JDBC STARTING...");
		      	long start = new Date().getTime();
		    	for(int i=0; i<LOAD_COUNT; i++) {
					  String sql = "delete FROM account where email_addr = ?";
					  stmt = conn.prepareStatement(sql);
					  stmt.setString(1, "test"+i+"@test.com");
					  
					  stmt.execute();
		    	}
		    	long end = new Date().getTime();
		    	log("DELETE LOAD TEST FOR PLAIN JDBC COMPLETE...");
		    	log("PLAIN JDBC LOAD TEST TOTAL DELETE TIME (ms): " + (end - start));
			} finally {
				if(stmt != null) {
					stmt.close();
				}
			}
		}

		
		private static void updateAccounts(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			try {
				log("UPDATE LOAD TEST FOR PLAIN JDBC STARTING...");
		      	long start = new Date().getTime();
		      	Date dt = new Date();
		      	java.sql.Date now = new java.sql.Date(dt.getTime());
		      	
		    	for(int i=0; i<LOAD_COUNT; i++) {
					  String sql = "update account set first_name=?, last_name=?, last_modified_date=? where email_addr = ?";
					  stmt = conn.prepareStatement(sql);
					  stmt.setString(1, "LoadTestFNUpdated");
					  stmt.setString(2, "LoadTestLNUpdated");
					  stmt.setDate(3, now);
					  stmt.setString(4, "test"+i+"@test.com");
					  
					  stmt.execute();
		    	}
		    	long end = new Date().getTime();
		    	log("UPDATE LOAD TEST FOR PLAIN JDBC COMPLETE...");
		    	log("PLAIN JDBC LOAD TEST TOTAL UPDATE TIME (ms): " + (end - start));
			} finally {
				if(stmt != null) {
					stmt.close();
				}
			}
		}
		

		private static void findAccounts(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			try {
				log("FINDER LOAD TEST FOR PLAIN JDBC STARTING...");
		      	long start = new Date().getTime();
		    	for(int i=0; i<LOAD_COUNT; i++) {
				  String sql = "select * from account where email_addr=?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1, "test"+i+"@test.com");
				  ResultSet rs = stmt.executeQuery();
				
				  while(rs.next()){
					 rs.getInt("account_id");
					 rs.getString("email_addr");
					 rs.getString("first_name");
					 rs.getString("last_name");
					 rs.getString("password");
					 rs.getString("salt");
				  }
		    	}
		    	long end = new Date().getTime();
		    	log("FINDER LOAD TEST FOR PLAIN JDBC COMPLETE...");
		    	log("PLAIN JDBC LOAD TEST TOTAL FINDER TIME (ms): " + (end - start));
			} finally {
				if(stmt != null) {
					stmt.close();
				}
			}
		}

		private static void insertAccounts(Connection conn) throws SQLException {
			PreparedStatement stmt = null;
			try {
				log("INSERT LOAD TEST FOR PLAIN JDBC STARTING...");
		      	long start = new Date().getTime();
		      	Date dt = new Date();
		      	java.sql.Date now = new java.sql.Date(dt.getTime());
		    	for(int i=0; i<LOAD_COUNT; i++) {
					  String sql = "insert into account (account_id, email_addr, password, salt, first_name, last_name, " +
					  		"status, roles, created_date, last_modified_date ) values " +
					  		"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					  stmt = conn.prepareStatement(sql);
					  stmt.setLong(1, 200000+i);
					  stmt.setString(2, "test"+i+"@test.com");
					  stmt.setString(3, "passwordpasswordpasswordpasswordpasswordpasswordpassword");
					  stmt.setString(4, "saltysaltysaltysaltysalty");
					  stmt.setString(5, "LoadTestFN");
					  stmt.setString(6, "LoadTestLN");
					  stmt.setInt(7, 1);
					  stmt.setString(8, "ROLE_TEST_USER");
					  stmt.setDate(9, now);
					  stmt.setDate(10, now);
					  
					  stmt.execute();
		    	}
		    	long end = new Date().getTime();
		    	log("INSERT LOAD TEST FOR PLAIN JDBC COMPLETE...");
		    	log("PLAIN JDBC LOAD TEST TOTAL INSERT TIME (ms): " + (end - start));
			} finally {
				if(stmt != null) {
					stmt.close();
				}
			}
		}

		private static void log(String msg) {
			System.err.println(msg);
		}
}
