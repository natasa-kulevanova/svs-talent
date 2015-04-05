package menus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import entities.Member;
import librarydataaccess.HibernateMemberDao;
import services.MemberService;

public class MemberMenu  {

	static MemberService memberService = new MemberService(new HibernateMemberDao());
	static InputStreamReader inp = new InputStreamReader(System.in);
	static BufferedReader buff = new BufferedReader(inp);
	
	public static void listMember() {
		List<Member> members = memberService.listMember();
		System.out.println("Full list of members:");
		for (Member m : members) {		
			System.out.println("Member id: " + m.getId());
			System.out.println("Member name: " + m.getName());
			System.out.println("Member e-mail: " + m.getEmail());	
		}
	}

	public static void registerMember(Scanner memIn) {
		try{
			System.out.println("Enter member name:");
			String name = buff.readLine();
			System.out.println("Enter member e-mail:");
			String email = buff.readLine();
			Member m = new Member(name, email);
			memberService.registerMember(m);
		}catch (Exception e){
			System.out.println("Something went wrong.");
		}
	/*	System.out.println("Enter member name:");
		String name = memIn.next();
		System.out.println("Enter member e-mail:");
		String email = memIn.nextLine();
		Member m = new Member(name, email);
		memberService.registerMember(m);	*/
	}

	public static void deleteMember(Scanner memIn) {
		System.out.println("Enter member id:");
		int id = memIn.nextInt();
		memberService.deleteMember(id);
	}

	public static void updateMember(Scanner memIn){
		System.out.println("Enter the id of the member that you want to update:");
		int id = memIn.nextInt();
		try{
			System.out.println("Enter new member name:");
			String name = buff.readLine();
			System.out.println("Enter new member e-mail:");
			String email = buff.readLine();
			Member m = new Member();
			m.setId(id);
			m.setName(name);
			m.setEmail(email);
			memberService.updateMember(m);
		}catch (Exception e){
			System.out.println("Something went wrong.");
		}
		/*System.out.println("Enter new member name:");
		String name = memIn.next();
		System.out.println("Enter new member e-mail:");
		String email = memIn.next();
		Member m = new Member();
		m.setId(id);
		m.setName(name);
		m.setEmail(email);
		memberService.updateMember(m);*/
	}

}
