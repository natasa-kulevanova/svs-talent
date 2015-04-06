package templatepattern;

import org.hibernate.Session;

public interface CheckSetter {

	public boolean checkAction(Session s);
}
