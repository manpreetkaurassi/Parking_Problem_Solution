package dbadmin.Entity;

public class User {
	public User(int userId, String userName, int userAge, String userAddress, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userAddress = userAddress;
		this.password = password;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName ;
	}

	/**
	 * @param name the name to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userAge
	 */
	public int getUserAge() {
		return userAge;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	
	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress ;
	}

	/**
	 * @param name the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password ;
	}

	/**
	 * @param name the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	
	
	private int userId;
	private String userName;
	private int userAge;
	private String userAddress;
	private String password;

	public User() {}
}
