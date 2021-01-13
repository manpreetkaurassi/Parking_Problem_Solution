package dbadmin.Dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import dbadmin.Entity.BookingDetails;
import dbadmin.Entity.User;


public interface UserDao {

	/* (non-Javadoc)
	 * @see dbadmin.Dao.UserDao#getAllUsers()
	 */
	Collection<User> getAllUsers();

	/* (non-Javadoc)
	 * @see dbadmin.Dao.UserDao#getUserById(int)
	 */
	User getUserById(int userId);

	/* (non-Javadoc)
	 * @see dbadmin.Dao.UserDao#delUserById(int)
	 */
	void delUserById(int userId);

	/* (non-Javadoc)
	 * @see dbadmin.Dao.UserDao#updateUserById(dbadmin.Entity.User)
	 */
	void updateUserById(User user);

	/* (non-Javadoc)
	 * @see dbadmin.Dao.UserDao#insertUser(dbadmin.Entity.User)
	 */
	void insertUser(User user);

	void loginCheck(String username, String password);

	void userBooking(BookingDetails bookingdetails);

}