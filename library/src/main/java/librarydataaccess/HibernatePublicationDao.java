package librarydataaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.PublicationDao;
import templatepattern.ActionSetter;
import templatepattern.CheckSetter;
import templatepattern.HibernateTemplate;
import templatepattern.ReadActionSetter;
import entities.Publication;

public class HibernatePublicationDao implements PublicationDao {

	public void registerPublication(final Publication p) {

		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.save(p);

			}
		});
	}

	public List<Publication> listPublication() {

		return HibernateTemplate.doListAction(new ReadActionSetter<List<Publication>>() {

					public List<Publication> readAction(Session s) {
						List<Publication> pubs;
						String hql = "FROM Publication";
						Query query = s.createQuery(hql);
						pubs = query.list();
						return pubs;
					}
				});
	}

	public void updatePublication(final Publication p) {

		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				//s.save(p);
				s.update(p);
			}
		});
	}

	public void deletePublication(final int id) {

		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				Publication p = (Publication) s.get(Publication.class, id);
				s.delete(p);
			}
		});
	}
	
	public boolean checkPublicationID(final int id){
		return HibernateTemplate.checkAction(new CheckSetter() {
			
			public boolean checkAction(Session s) {
				// TODO Auto-generated method stub
				String hql = "SELECT COUNT(*) FROM Publication WHERE id = :idP";
				Query query = s.createQuery(hql);
				query.setParameter("idP", id);
				List pubs = query.list();
				Number count = (Number) pubs.get(0);
				if (count.intValue() == 0) {
					return false;
				} else
					return true;
			}
		});
	}
	/*public boolean checkPublicationSifra(final String sifra){
		return HibernateTemplate.checkAction(new CheckSetter() {
			
			public boolean checkAction(Session s) {
				// TODO Auto-generated method stub
				String hql = "SELECT COUNT(*) FROM Book WHERE isbn = : isbnP";
				Query query = s.createQuery(hql);
				query.setParameter("isbnP", sifra);
				List pubs = query.list();
				if (pubs.size()==0) {
					String hql2 = "SELECT COUNT(*) FROM Magazine WHERE issn = : issnP";
					Query query2 = s.createQuery(hql2);
					query.setParameter("issnP", sifra);
					List pubs2 = query2.list();
					if(pubs2.size()==0)
					return false;
					else
						return true;
				} else
					return true;
			}
		});
	}*/
}
