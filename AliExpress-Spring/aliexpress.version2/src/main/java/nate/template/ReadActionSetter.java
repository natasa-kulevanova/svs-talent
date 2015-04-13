package nate.template;

import org.hibernate.Session;

public interface ReadActionSetter<T> {

	public T readAction(Session s); 

}
