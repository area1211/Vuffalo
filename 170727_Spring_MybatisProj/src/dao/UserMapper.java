package dao;

import java.util.List;

import model.User;

public interface UserMapper {
	List<User> selectAllUsers();
	User selectUser(String username);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(String username);
}
