package my.test.querydsl;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import my.test.querydsl.hib.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.hibernate.HibernateDeleteClause;
import com.mysema.query.jpa.hibernate.HibernateUpdateClause;
import com.mysema.query.sql.HSQLDBTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.dml.SQLDeleteClause;
import com.mysema.query.sql.dml.SQLInsertClause;
import com.mysema.query.sql.dml.SQLUpdateClause;

public class AccountDalTest 
{
	private static final int LOAD_COUNT = 5000;
    public static void main( String[] args ) throws SQLException, ParseException
    {
        Connection c = getConnection();
        if(c == null) {
        	log("Unable to establish connection");
        }
        
//        insertAccount(c);
//        
//        findAccount(c);
//        
//        updateAccount(c);
//        
//        findAccount(c);
//        
//        deleteAccount(c);
//        
//        findAccount(c);
        
//        log("\n\n%%%%%%%%% HIBERNATE TESTS %%%%%%%");
//        loadTestHibernate(c);
        
        log("\n\n%%%%%%%%% SQL TEMPLATE TESTS %%%%%%%");
        loadTestSQLTemplate(c);
        
    }

	private static void loadTestSQLTemplate(Connection c) throws SQLException {
    	QAccount account = QAccount.account;
    	SQLTemplates dialect = new HSQLDBTemplates();
    	Timestamp date = new Timestamp(new Date().getTime());
    	
    	log("\n*********************************");
    	log("INSERT LOAD TEST FOR SQLTEMPLATE STARTING...");
    	long start = new Date().getTime();
    	for(int i=0; i<LOAD_COUNT; i++) {
        	new SQLInsertClause(c, dialect, account).columns(
        			account.accountId, account.firstName, account.lastName, account.createdDate,
    				account.emailAddr, account.lastModifiedDate, account.password, account.salt, 
    				account.status, account.roles)
    				.values(
    				100000+i, "LoadTestFN", "LoadTestLN", date,
    				"test"+i+"@test.com", date, "passwordpasswordpasswordpasswordpasswordpasswordpassword", "saltysaltysaltysaltysalty", 
    				1, "ROLE_TEST_USER").execute();
    	}
    	long end = new Date().getTime();
    	log("INSERT LOAD TEST FOR SQLTEMPLATE COMPLETE...");
    	log("SQL TEMPLATE LOAD TEST TOTAL INSERT TIME (ms): " + (end - start));
    	log("\n*********************************");
    	
    	
    	log("UPDATE LOAD TEST FOR SQLTEMPLATE STARTING...");
    	start = new Date().getTime();
    	for(int i=0; i<LOAD_COUNT; i++) {
    		new SQLUpdateClause(c, dialect, account)
			.set(account.firstName, "LoadTestFNUpdated")
			.set(account.lastName, "LoadTestLNUpdated")
			.set(account.lastModifiedDate, new Timestamp(new Date().getTime()))
			.where(account.emailAddr.eq("test"+i+"@test.com")).execute();
    	}
    	end = new Date().getTime();
    	log("UPDATE LOAD TEST FOR SQLTEMPLATE COMPLETE...");
    	log("SQL TEMPLATE LOAD TEST TOTAL UPDATE TIME (ms): " + (end - start));
    	log("\n*********************************");
    	
    	log("FINDER LOAD TEST FOR SQLTEMPLATE STARTING...");
    	start = new Date().getTime();
    	for(int i=0; i<LOAD_COUNT; i++) {
    		new SQLQuery(c, dialect)
    			.from(account)
    		    .where(account.emailAddr.eq("test"+i+"@test.com"))
    		    .list(account.all());
    	}
    	end = new Date().getTime();
    	log("FINDER LOAD TEST FOR SQLTEMPLATE COMPLETE...");
    	log("SQL TEMPLATE LOAD TEST TOTAL FINDER TIME (ms): " + (end - start));
    	log("\n*********************************");
    	
    	log("DELETE LOAD TEST FOR SQLTEMPLATE STARTING...");
    	start = new Date().getTime();
    	for(int i=0; i<LOAD_COUNT; i++) {
        	new SQLDeleteClause(c, dialect, account)
        		.where(account.emailAddr.eq("test"+i+"@test.com"))
        		.execute();
    	}
    	end = new Date().getTime();
    	log("DELETE LOAD TEST FOR SQLTEMPLATE COMPLETE...");
    	log("SQL TEMPLATE LOAD TEST TOTAL DELETE TIME (ms): " + (end - start));
    	log("\n*********************************");
    	
	}

	private static void loadTestHibernate(Connection c) throws SQLException {
        Session s = getHibernateSession();

        Date now = new Date();
        
    	log("*********************************");
    	log("INSERT LOAD TEST FOR HIBERNATE STARTING...");
    	long start = new Date().getTime();
    	for(int i=0; i<LOAD_COUNT; i++) {
    		Transaction trans = s.beginTransaction();
        	Account hc = new Account();
        	hc.setAccountId(200000L+i);
        	hc.setFirstName("LoadTestFN");
        	hc.setLastName("LoadTestLN");
        	hc.setCreatedDate(now);
        	hc.setEmailAddr("test"+i+"@test.com");
        	hc.setLastModifiedDate(now);
        	hc.setPassword("passwordpasswordpasswordpasswordpasswordpasswordpassword");
        	hc.setSalt("saltysaltysaltysaltysalty");
        	hc.setStatus(new Integer(1).byteValue());
        	hc.setRoles("ROLE_TEST_USER");
        	
    		s.save(hc);
    		trans.commit();
    	}
    	long end = new Date().getTime();
    	log("INSERT LOAD TEST FOR HIBERNATE COMPLETE...");
    	log("HIBERNATE LOAD TEST TOTAL INSERT TIME (ms): " + (end - start));
    	log("*********************************");
    	
    	
    	
    	my.test.querydsl.hibernate.QAccount acc = my.test.querydsl.hibernate.QAccount.account;
    	
    	
    	
    	log("UPDATE LOAD TEST FOR HIBERNATE STARTING...");
    	start = new Date().getTime();
    	for(int i=0; i<LOAD_COUNT; i++) {
    		new HibernateUpdateClause(s, acc)
				.set(acc.firstName, "LoadTestFNUpdated")
				.set(acc.lastName, "LoadTestLNUpdated")
				.set(acc.lastModifiedDate, new Timestamp(new Date().getTime()))
				.where(acc.emailAddr.eq("test"+i+"@test.com"))
			.execute();
    	}
    	end = new Date().getTime();
    	log("UPDATE LOAD TEST FOR HIBERNATE COMPLETE...");
    	log("HIBERNATE LOAD TEST TOTAL UPDATE TIME (ms): " + (end - start));
    	log("*********************************");
    	
    	
    	log("FINDER LOAD TEST FOR HIBERNATE STARTING...");
    	start = new Date().getTime();
    	for(int i=0; i<LOAD_COUNT; i++) {
//    		HQLQuery query = new HibernateQuery(s);
//    		query
//				.from(acc)
//			    .where(acc.emailAddr.eq("test"+i+"@test.com"))
//			    .list();
    		
    		org.hibernate.SQLQuery _query = s.createSQLQuery("select * from account where email_addr = :eid ");
    		_query.setParameter("eid", "test"+i+"@test.com");
    		_query.addEntity(Account.class);
    		_query.list();
    	}
    	end = new Date().getTime();
    	log("FINDER LOAD TEST FOR HIBERNATE COMPLETE...");
    	log("HIBERNATE LOAD TEST TOTAL FINDER TIME (ms): " + (end - start));
    	log("*********************************");
    	
    	log("DELETE LOAD TEST FOR HIBERNATE STARTING...");
    	start = new Date().getTime();
    	for(int i=0; i<LOAD_COUNT; i++) {
    		new HibernateDeleteClause(s, acc)
	    		.where(acc.emailAddr.eq("test"+i+"@test.com"))
	    		.execute();
    	}
    	end = new Date().getTime();
    	log("DELETE LOAD TEST FOR HIBERNATE COMPLETE...");
    	log("SQL TEMPLATE LOAD TEST TOTAL DELETE TIME (ms): " + (end - start));
    	log("*********************************");
    	
		s.close();
	}

	private static Session getHibernateSession() {
		URL location = AccountDalTest.class.getProtectionDomain().getCodeSource().getLocation();
        String beanFilePath = location.getFile();
		ApplicationContext context = new 
				FileSystemXmlApplicationContext(beanFilePath + "DBHibernateConfig.xml");
		
		SessionFactory factory = (SessionFactory) context.getBean("invdbSessionFactory");
//		Session session = factory.getCurrentSession();
		Session session = factory.openSession();
		return session;
	}

	private static Connection getConnection() {
		try {
			return DriverManager
					.getConnection(
							"jdbc:mysql://ec2-54-234-99-88.compute-1.amazonaws.com:3306/invdb",
							"user5", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
    }
    
    private static void insertAccount(Connection c) throws SQLException, ParseException {
    	QAccount account = QAccount.account;
    	SQLTemplates dialect = new HSQLDBTemplates();
    	
    	Timestamp date = new Timestamp(new Date().getTime());
    	
    	log("DEFAULT AUTO COMMIT IS: " + c.getAutoCommit());
    	
		c.setAutoCommit(false);
		
    	SQLInsertClause s = new SQLInsertClause(c, dialect, account).columns(
    			account.accountId, account.firstName, account.lastName, account.createdDate,
				account.emailAddr, account.lastModifiedDate, account.password, account.salt, 
				account.status, account.roles)
				.values(
				10001, "Madhu", "Varadan", date,
				"mvaradan@yahoo.com", date, "junk", "very_salty", 
				1, "ROLE_USER");
    	
    	log("INSERT QUERY: " + s.toString());
    	
    	s.execute();
    	
    	log("WAIT............VERIFY AUTO COMMIT");
		
    	c.commit();
    }
    
	private static void updateAccount(Connection c) throws SQLException {
    	QAccount account = QAccount.account;
    	SQLTemplates dialect = new HSQLDBTemplates();
    	
    	c.setAutoCommit(true);
		SQLUpdateClause u = new SQLUpdateClause(c, dialect, account)
			.set(account.firstName, "Madhusudan")
			.set(account.lastModifiedDate, new Timestamp(new Date().getTime()))
			.where(account.emailAddr.eq("mvaradan@yahoo.com"));
		
		log("UPDATE QUERY: " + u.toString());
		u.execute();
		
	}
    
    private static void deleteAccount(Connection c) throws SQLException {
    	QAccount account = QAccount.account;
    	SQLTemplates dialect = new HSQLDBTemplates();
    	
		c.setAutoCommit(true);
    	SQLDeleteClause d = new SQLDeleteClause(c, dialect, account)
        	.where(account.emailAddr.eq("mvaradan@yahoo.com"));
        
    	log("DELETE QUERY: " + d.toString());
    	d.execute();
	}

	private static void findAccount(Connection c) {
		QAccount account = QAccount.account;
		
		SQLTemplates dialect = new HSQLDBTemplates(); // SQL-dialect
		SQLQuery query = new SQLQuery(c, dialect); 
		SQLQuery f = query.from(account)
		    .where(account.emailAddr.eq("mvaradan@yahoo.com"));
		
		log("SELECT QUERY: " + f.toString());
		
		List<Tuple> a = f.list(account.all());
		log("Account from the query: " + ((a != null) ? a.toString() : "NO record found"));
	}
	
	private static void log(String msg) {
		System.err.println(msg);
	}
}
