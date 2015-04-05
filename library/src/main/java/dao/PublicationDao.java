package dao;

import java.util.List;

import entities.Publication;

public interface PublicationDao {

	public void registerPublication(Publication p);
	public List<Publication> listPublication();
	public void updatePublication(Publication p);
	public void deletePublication(int id);
}
