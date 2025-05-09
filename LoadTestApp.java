package in.abc.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.abc.Model.InsurancePolicy;
import in.abc.util.HibernateUtil;

public class LoadTestApp {

	public static void main(String[] args) {
		
		Session session = null;
		InsurancePolicy policy = null;
		
		session = HibernateUtil.getSession();
		
		try {
			policy = session.get(InsurancePolicy.class, 3L);
			if (policy != null) {
				System.out.println("Record found and displayed...");
				System.out.println(policy);
			} else {
				System.out.println("Record not found...");
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

}
