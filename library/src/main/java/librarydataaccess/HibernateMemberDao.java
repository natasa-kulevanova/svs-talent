package librarydataaccess;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import dao.MemberDao;
import templatepattern.ActionSetter;
import templatepattern.HibernateTemplate;
import templatepattern.ReadActionSetter;
import entities.Member;

public class HibernateMemberDao implements MemberDao {

	public void registerMemeber(final Member m) {
		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.save(m);

			}
		});
	}

	public List<Member> listMember() {

		return HibernateTemplate.doListAction(new ReadActionSetter<List<Member>>() {

			public List<Member> readAction(Session s) {
				List<Member> members;
				String hql = "FROM Member";
				Query query = s.createQuery(hql);
				members = query.list();
				return members;
			}
		});		
	}

	public void updateMember(final Member mem) {
		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.update(mem);
				//s.save(mem);
			}
		});		
	}

	public void deleteMember(final int id) {

		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				Member m = (Member) s.get(Member.class, id);
				s.delete(m);
			}
		});
	}

}
