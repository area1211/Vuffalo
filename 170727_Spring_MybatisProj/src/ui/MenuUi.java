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
		System.out.println("[ȸ�� ����]");
		System.out.println("0. ����");
		System.out.println("1. ȸ����ȸ");
		System.out.println("2. ȸ���߰�");
		System.out.println("3. ȸ������");
		System.out.println("4. ȸ������");
		System.out.println("5. ��üȸ����ȸ");
		System.out.print("���� > ");
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
		System.out.println("[ȸ�� ��ȸ]");
		System.out.print("�̸� : ");
		String name=sc.nextLine();
		
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.selectUser(name);
		if(user == null){
			System.out.println("!!! �������� �ʴ� ȸ���Դϴ� !!!");
			sqlSession.close();
			return;
		}
		System.out.println(user);
		sqlSession.close();
	}
	
	void insertUser(){
		System.out.println("[ȸ�� �߰�]");
		System.out.print("�̸�  : ");
		String name=sc.nextLine();
		System.out.print("��й�ȣ : ");
		String password=sc.nextLine();
		System.out.print("�̸��� : ");
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
		System.out.println("[ȸ�� ����]");
		System.out.print("�̸� :");
		String name=sc.nextLine();
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user= userMapper.selectUser(name);
		if(user == null){
			System.out.println("!!! �������� �ʴ� ȸ���Դϴ� !!!");
			sqlSession.close();
			return;
		}
		System.out.print("1.��й�ȣ����/2.�̸��Ϻ��� : ");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel){
		case 1:
			System.out.print("* ���ο� ��й�ȣ�� �Է��ϼ��� :");
			String password=sc.nextLine();
			user.setPassword(password);
		case 2:
			System.out.print("* ���ο� �̸����� �Է��ϼ��� : ");
			String email=sc.nextLine();
			user.setEmail(email);
		}
		
		userMapper.updateUser(user);
		
		sqlSession.close();
	}
	
	void deleteUser(){
		System.out.println("[ȸ�� ����]");
		System.out.print("�̸� :");
		String name=sc.nextLine();
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user= userMapper.selectUser(name);
		if(user == null){
			System.out.println("!!! �������� �ʴ� ȸ���Դϴ� !!!");
			sqlSession.close();
			return;
		}
		System.out.print("* ��й�ȣ�� �Է����ּ��� : ");
		String password=sc.nextLine();
		if(!user.getPassword().equals(password)){
			System.out.println("!!! ��й�ȣ�� ��ġ���� �ʽ��ϴ�. ���θ޴��� ���ư��ϴ� !!!");
			return;
		}
		
		userMapper.deleteUser(name);
		System.out.println("** ������ �Ϸ�Ǿ����ϴ�.");
		sqlSession.close();
	}
	
	void selectAllUser() {
		System.out.println("[��ü ȸ�� ��ȸ]");
		
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.selectAllUsers();
		if(list.size()==0){
			System.out.println("!!! ȸ���� �������� �ʽ��ϴ�. !!!");
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
