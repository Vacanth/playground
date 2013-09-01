package my.test.querydsl;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TestDao extends HibernateDaoSupport {
	public Session getDalSession() {
		Session session = getSessionFactory().getCurrentSession();
		return session;
	}
}
