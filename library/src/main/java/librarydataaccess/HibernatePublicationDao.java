package librarydataaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import dao.PublicationDao;
import templatepattern.ActionSetter;
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
}
