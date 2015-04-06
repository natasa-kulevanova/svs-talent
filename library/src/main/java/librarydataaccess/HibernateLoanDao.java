package librarydataaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import dao.LoanDao;
import templatepattern.ActionSetter;
import templatepattern.HibernateTemplate;
import templatepattern.ReadActionSetter;
import entities.Loan;

public class HibernateLoanDao implements LoanDao{

	public void registerLoan(final Loan l) {
		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				// TODO Auto-generated method stub
				s.save(l);

			}
		});
	}

	public List<Loan> listLoan() {
		return HibernateTemplate.doListAction(new ReadActionSetter<List<Loan>>() {

			public List<Loan> readAction(Session s) {
				List<Loan> loans;
				String hql = "FROM Loan";
				Query query = s.createQuery(hql);
				loans = query.list();
				return loans;
			}
		});
	}

	public void updateLoan(final Loan l) {
		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.update(l);
			}
		});
	}

	public void deleteLoan(final int id) {
		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				// TODO Auto-generated method stub
				Loan l = (Loan) s.get(Loan.class, id);
				s.delete(l);
			}
		});
	}
}
