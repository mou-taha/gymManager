package ma.gymmanager;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.gymmanager.Service.IUserService;
import ma.gymmanager.dao.UserRepository;
import ma.gymmanager.domaine.RoleVo;
import ma.gymmanager.domaine.UserVo;
import ma.gymmanager.model.Role;
import ma.gymmanager.model.User;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	

	@Autowired
	IUserService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder; 
	} 
	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		// userService.save(new RoleVo("COACH"));
		// userService.save(new RoleVo("CLIENT"));
		// userService.save(new RoleVo("ADMIN"));
		// userService.save(new RoleVo("SUPERADMIN"));
		// RoleVo coach=userService.getRoleByName("COACH");
		// userService.add(new UserVo("a","a",Arrays.asList(coach)));
	}

}
