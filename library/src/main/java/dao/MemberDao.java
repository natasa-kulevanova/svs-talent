package dao;

import java.util.List;
import entities.Member;

public interface MemberDao {

	public void registerMemeber(Member m);

	public List<Member> listMember();

	public void updateMember(Member m);

	public void deleteMember(int id);
}
