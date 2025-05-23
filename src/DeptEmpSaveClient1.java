
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeptEmpSaveClient1 {

	public static void main(String[] args) {
		Emp e1=new Emp(0, "acb", 100000.00, "Desi", null);
		Emp e2=new Emp(0, "cdf", 100000.00, "Des", null);
		Emp e3=new Emp(0, "rut", 100000.00, "Designer", null);
		Emp e4=new Emp(0, "ruth", 100000.00, "Desig", null);
		
		
		List<Emp> empList=new ArrayList<Emp>();
		empList.add(e1); 
		
		Dept d1=new Dept(0, "pat", "Hyderbad", empList);
		
		Session s=HSFactory.getSession();
		Transaction t=s.beginTransaction();
		
		try {
			
			s.save(d1);
			s.flush();
			t.commit();
			System.out.println("TX Success");
		} catch (Exception e) {
			t.rollback();
			System.out.println("TX Failed");
			e.printStackTrace();
		}
	}
}
