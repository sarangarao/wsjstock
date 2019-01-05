package poc.oauth.emc.wsje.security;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Dev",30, 70000));
		users.add(new User(counter.incrementAndGet(),"Ankit",40, 50000));
		users.add(new User(counter.incrementAndGet(),"Rahul",45, 30000));
		users.add(new User(counter.incrementAndGet(),"Akshay",50, 40000));
		return users;
	}
	
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
}
