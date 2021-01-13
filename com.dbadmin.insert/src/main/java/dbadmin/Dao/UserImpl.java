package dbadmin.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import dbadmin.Entity.BookingDetails;
import dbadmin.Entity.User;

@Repository
@Qualifier("user")
public  class UserImpl implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static class RowMapperUser implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setUserAge(rs.getInt(3));		
			user.setUserAddress(rs.getString(4));
			user.setPassword(rs.getString(5));
			return user;								
		}
		
	}
	
	//Row-Mapper is an Interface, which we will need to implement
	@Override
	public Collection<User> getAllUsers() {
			final  String sql = "SELECT * from UserDB";
			List<User> users = jdbcTemplate.query(sql, new RowMapperUser());
		return users;
	}


	@Override
	public User getUserById(int userId) {
		final  String sql = "SELECT * from UserDB where userId = ?";
		User user = jdbcTemplate.queryForObject(sql, new RowMapperUser(),userId);
		return user;
	}


	@Override
	public void delUserById(int userId) {
		final  String sql = "DELETE FROM UserDb WHERE userId = ?";
		jdbcTemplate.update(sql, userId);
		
	}


	@Override
	public void updateUserById(User user) {
		final int userId = user.getUserId();
		final String userName  = user.getUserName();
		final int userAge = user.getUserAge();
		final String userAddress = user.getUserAddress();
		final String userPassword = user.getPassword();
		
		
		
		final  String sql = "UPDATE name = ?, userAge = ? WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[] {userName, userAge , userId });
		
	}


	@Override
	public void insertUser(User user) {
		final  String sql = "INSERT into UserDB (userId, userName , userAge, userAddress, password) values (?,?,?,?,?)";
		
		//"INSERT INTO UserDB (userId, userName,userAge, userAddress,password ) VALUES (2, 'Badam',13,'Boston','badam123')";
		
		System.out.print(sql);
		final int userId = user.getUserId();
		final String userName  = user.getUserName();
		final int userAge = user.getUserAge();
		final String userAddress = user.getUserAddress();
		final String password = user.getPassword();
		
		
		System.out.println(userId);
		System.out.println(userName);
		System.out.println(userAge);
		System.out.println(userAddress);
		System.out.println(password);
		
		Object[] params = new Object[] { userId, userName, userAge,userAddress, password  };
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR };
		System.out.println("ROW PRINTING");
		int row = jdbcTemplate.update(sql, params, types);
		System.out.println(row);
	}

	@Override
	public void loginCheck(String username, String password) {
		// TODO Auto-generated method stub
		final  String sql = "select count(*) from UserDB where userName = ? and password = ?;";

//		final  String sql = "select count(*) from UserDB where userName = "+username+ " and password = "+password+";";
//		List<Map<String, Object>> row = jdbcTemplate.queryForList("select count(*) from t_actor");
		
//		int row = jdbcTemplate.queryforint();
		int count = jdbcTemplate.queryForObject(
                sql, new Object[] { username,password }, Integer.class);
		System.out.print("rows received "+count);
		if(count == 0) throw new IllegalArgumentException();
		
	}

	@Override
	public void userBooking(BookingDetails bookingdetails) {
		// TODO Auto-generated method stub
final  String sql = "INSERT into BookingDB ( bookingTime , bookingDate, parkingId) values ('"+bookingdetails.getBooking_time()
+"','"+bookingdetails.getBooking_date()+"','"+bookingdetails.getParking_id()+"')";
		System.out.println("ROW PRINTING");
		int row = jdbcTemplate.update(sql);
		System.out.println(row);
		
	}



}