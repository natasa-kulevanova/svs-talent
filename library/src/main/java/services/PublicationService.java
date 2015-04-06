package services;

import java.util.List;

import dao.BookDao;
import dao.PublicationDao;
import entities.Book;
import entities.Publication;
import librarydataaccess.HibernatePublicationDao;

public class PublicationService {

	PublicationDao pubDao;

	public PublicationService(PublicationDao p) {
		this.pubDao = p;
	}

	public List getPublications() {
		return pubDao.listPublication();
	}

	public void registerPublication(Publication p) {
		pubDao.registerPublication(p);
	}

	public void deletePublication(int id) {
		pubDao.deletePublication(id);
	}

	public void updatePublication(Publication p) {
		pubDao.updatePublication(p);
	}
	
	public boolean checkPublicationID(int id){
		return pubDao.checkPublicationID(id);
	}
	/*
	 * public boolean checkPublicationSifra(String sifra){ return
	 * pubDao.checkPublicationSifra(sifra); }
	 */
}
