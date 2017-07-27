package ui;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.MyBatisConfig;
import dao.UserMapper;
import model.User;

public class MenuUi {	
	Scanner sc = new Scanner(System.in);
	
	
	int showMenu(){
		System.out.println("[회원 관리]");
		System.out.println("0. 종료");
		System.out.println("1. 회원조회");
		System.out.println("2. 회원추가");
		System.out.println("3. 회원변경");
		System.out.println("4. 회원삭제");
		System.out.println("5. 전체회원조회");
		System.out.print("선택 > ");
		int sel=Integer.parseInt(sc.nextLine());
		return sel;
	}
	void show(){
		int sel;
		while((sel=showMenu())!=0){
			System.out.println();
			switch(sel){
			case 1:selectUser();break;
			case 2:insertUser();break;
			case 3:updateUser();break;
			case 4:deleteUser();break;
			case 5:selectAllUser(); break;
			}
			System.out.println();
		}
	}
	
	void selectUser() {
		System.out.println("[회원 조회]");
		System.out.print("이름 : ");
		String name=sc.nextLine();
		
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.selectUser(name);
		if(user == null){
			System.out.println("!!! 존재하지 않는 회원입니다 !!!");
			sqlSession.close();
			return;
		}
		System.out.println(user);
		sqlSession.close();
	}
	
	void insertUser(){
		System.out.println("[회원 추가]");
		System.out.print("이름  : ");
		String name=sc.nextLine();
		System.out.print("비밀번호 : ");
		String password=sc.nextLine();
		System.out.print("이메일 : ");
		String email=sc.nextLine();
		
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		
		User user=new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setEmail(email);
		userMapper.insertUser(user);
		sqlSession.close();
	}
	
	void updateUser(){
		System.out.println("[회원 변경]");
		System.out.print("이름 :");
		String name=sc.nextLine();
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user= userMapper.selectUser(name);
		if(user == null){
			System.out.println("!!! 존재하지 않는 회원입니다 !!!");
			sqlSession.close();
			return;
		}
		System.out.print("1.비밀번호변경/2.이메일변경 : ");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel){
		case 1:
			System.out.print("* 새로운 비밀번호를 입력하세요 :");
			String password=sc.nextLine();
			user.setPassword(password);
		case 2:
			System.out.print("* 새로운 이메일을 입력하세요 : ");
			String email=sc.nextLine();
			user.setEmail(email);
		}
		
		userMapper.updateUser(user);
		
		sqlSession.close();
	}
	
	void deleteUser(){
		System.out.println("[회원 삭제]");
		System.out.print("이름 :");
		String name=sc.nextLine();
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user= userMapper.selectUser(name);
		if(user == null){
			System.out.println("!!! 존재하지 않는 회원입니다 !!!");
			sqlSession.close();
			return;
		}
		System.out.print("* 비밀번호를 입력해주세요 : ");
		String password=sc.nextLine();
		if(!user.getPassword().equals(password)){
			System.out.println("!!! 비밀번호가 일치하지 않습니다. 메인메뉴로 돌아갑니다 !!!");
			return;
		}
		
		userMapper.deleteUser(name);
		System.out.println("** 삭제가 완료되었습니다.");
		sqlSession.close();
	}
	
	void selectAllUser() {
		System.out.println("[전체 회원 조회]");
		
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.selectAllUsers();
		if(list.size()==0){
			System.out.println("!!! 회원이 존재하지 않습니다. !!!");
			sqlSession.close();
			return;
		}

		for(User user:list)
			System.out.println(user);
		sqlSession.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MenuUi menuUi = context.getBean(MenuUi.class);
		menuUi.show();
	}

}
