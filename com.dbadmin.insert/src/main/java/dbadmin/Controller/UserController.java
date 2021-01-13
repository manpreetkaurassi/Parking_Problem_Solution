package dbadmin.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import dbadmin.Entity.BookingDetails;
import dbadmin.Entity.User;
import dbadmin.Service.UserService;

@RestController
@Qualifier("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
//	@CrossOrigin(origins="http://localhost:8080")
//	@GetMapping("/getManu")
//	public String TestAjax(@RequestBody User user) {
//		System.out.println(user);
//		return ("Sucessful Manu");
//		
//	}
//	
	
	
	
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "access", method = RequestMethod.GET)
	public String greeting() {
		System.out.print("Welcome to OYO Parking");
		return "Welcome to OYO Parking";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "userBooking", method = RequestMethod.POST )	
	public String userBooking(@RequestBody BookingDetails bookingdetails,Model model, HttpServletRequest request, HttpServletResponse response, Model model1 ) {	
		System.out.println("INSIDE SERVLET");
		this.userService.userBooking(bookingdetails);
		return "Success Sign Up";
		
		
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public Collection<User> getAllUsers() {
//		return userService.getAllUsers();
//	}
//	
//	
//	@RequestMapping(value = "/{userId}",method = RequestMethod.GET)
//	public User getStudentById(@PathVariable("userId") int userId) {
//		return this.userService.getUserById(userId);
//	}
//	
//	//can be checked on postman(where you can select between GET, PUT, DELETE)
//	@RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
//	public void delStudentById(@PathVariable("userId") int userId) {
//		 this.userService.getUserById(userId);
//	}
//	
//	//will come from postman, type said -json, reading the request body
//	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void updateUserById(@RequestBody User user) {
//		this.userService.updateUserById(user); 		
//	}
//	
//	@RequestMapping(value = "insertdata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void insertUser(@RequestBody User user) {
//		this.userService.insertUser(user); 
//	}
	

	
	//TRYING TO GET THIS SUCCESS RESPONSE
//	@CrossOrigin(origins = "http://localhost:8080")
//	@RequestMapping(value = "insertdata", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })	
//	public String insertUser(@RequestParam("userId") int userId, @RequestParam("userName") String userName, 
//			@RequestParam("userAge") int userAge, 
//			@RequestParam("userAddress") String userAddress, @RequestParam("password") String password, Model model) {
//		
//		//this.userService.insertUser(user);
//		return "Success";
//		
//	}

	
	

		@CrossOrigin(origins = "*")
		@RequestMapping(value = "insertdata", method = RequestMethod.POST )	
		public String insertUser(@RequestBody User user,Model model, HttpServletRequest request, HttpServletResponse response, Model model1 ) {	
			System.out.println("INSIDE SERVLET");
			this.userService.insertUser(user);
			return "Success Sign Up";
			
			
		}
		
		@CrossOrigin(origins = "*")
		@RequestMapping(value = "logincheck", method = RequestMethod.GET )	
		public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password ) {	
			System.out.println("INSIDE SERVLET");
			this.userService.loginCheck(username, password);
			return "successful login";
			
			
		}
		
		@CrossOrigin(origins = "*")
		@RequestMapping(value = "userprofile", method = RequestMethod.POST )			
		public User vieuser(@RequestBody User user,Model model, HttpServletRequest request, HttpServletResponse response, Model model1 ) {	
			System.out.println("INSIDE SERVLET");
			int userId = user.getUserId();
			System.out.println(this.userService.getUserById(userId).getUserName());
			return this.userService.getUserById(userId);
			
		}
		
		
//	@CrossOrigin(origins = "http://localhost:8080")
//	@RequestMapping(value = "insertdata", method = RequestMethod.POST , produces = "application/json")	
//	public @ResponseBody User insertUser(@RequestBody User user,Model model, HttpServletRequest request ) {
//	//public void insertUser(@RequestBody User user, HttpServletRequest request ) {
//
//		this.userService.insertUser(user);
//		return user;
//		
//	}
//	
	
	
	
	
//	RequestMapping(value="/gDirecotry/ajax/searchUserProfiles.htm",method=RequestMethod.POST)	
//	public  @ResponseBody String  getSearchUserProfiles(@RequestBody Search search, HttpServletRequest request) {
//	    String pName = search.getPName();
//	    String lName = search.getLName();
//
//	    // your logic next
//	}
	
//	@CrossOrigin(origins = "http://localhost:8080")
//	@RequestMapping(value = "insertdata", method = RequestMethod.POST)	
//	public void insertUser(@RequestBody String s)
//	{
//		JsonObject user = JSON.object().add("name", "Sakib").add("age", 23);
//		JsonObject object = JsonObject.parse(s).asObject();
//		
//		JSONObject json = (JSONObject) parser.parse(s);
//		//User user = new User(userId,userName,userAge,userAddress,password);
//		//this.userService.insertUser(user); 
//		//return "Success";
//	}
//	 
	
	
	
	
}
