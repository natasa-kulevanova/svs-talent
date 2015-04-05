package services;

import java.util.List;

import dao.MemberDao;
import entities.Member;

public class MemberService {

	MemberDao memDao;

	public MemberService(MemberDao mDao) {
		memDao = mDao;
	}

	public List listMember() {
		return memDao.listMember();
	}
	
	public void registerMember(Member m) {
		memDao.registerMemeber(m);
	}

	public void updateMember(Member m) {
		memDao.updateMember(m);
	}

	public void deleteMember(int id) {
		memDao.deleteMember(id);
	}
}
