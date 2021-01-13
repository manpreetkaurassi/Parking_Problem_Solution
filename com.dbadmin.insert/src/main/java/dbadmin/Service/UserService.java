package dbadmin.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dbadmin.Dao.UserDao;
import dbadmin.Entity.BookingDetails;
import dbadmin.Entity.User;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("user")
	public UserDao userDao;
	
	public Collection<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserById(int userId) {
		return this.userDao.getUserById(userId);
	}
	
	public void delUserById(int userId) {
		this.userDao.getUserById(userId);
	}
	
	public void updateUserById(User user) {
		
		this.userDao.updateUserById(user); 		
	}
	
	public void insertUser(User user) {
		this.userDao.insertUser(user); 
	}
	public void loginCheck(String username, String password) {
		this.userDao.loginCheck(username,password);
	}

	public void userBooking(BookingDetails bookingdetails) {
		// TODO Auto-generated method stub
		System.out.println("inservice");
		this.userDao.userBooking(bookingdetails);
		
	}

}
