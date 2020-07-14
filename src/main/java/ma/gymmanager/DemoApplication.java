package ma.gymmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.gymmanager.Service.IEntraineurService;
import ma.gymmanager.Service.ISportService;
import ma.gymmanager.Service.IUserService;
import ma.gymmanager.Service.SportServiceImpl;
import ma.gymmanager.dao.UserRepository;
import ma.gymmanager.domaine.EntraineurConverter;
import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.domaine.RoleVo;
import ma.gymmanager.domaine.SportConverter;
import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.domaine.UserVo;
import ma.gymmanager.model.Role;
import ma.gymmanager.model.Sport;
import ma.gymmanager.model.User;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	IUserService userService;

	@Autowired
	ISportService sportService;

	@Autowired
	IEntraineurService entraineurService;

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

// 		// EntraineurVo entraineur = new EntraineurVo();
// 		// entraineur.setNom("test ");
// 		// entraineur.setCinN("4444");
// 		// entraineur.setEmail("t.mousnia@gmail.com");

		// // SportVo sport = sportService.getById(8);
		// // SportVo sport2 = sportService.getById(9);

		// //  List<SportVo> sportslist = new ArrayList<>();
		// //  sportslist.add(sport);
		// //  sportslist.add(sport2);
		// //  entraineur.setSports(SportConverter.toListBo(sportslist));

		// entraineur= entraineurService.save(entraineur);
		// sport.setEntraineur(EntraineurConverter.toBo( entraineur));
		// sportService.save(sport);
		// sport2.setEntraineur(EntraineurConverter.toBo(entraineur));
		// sportService.save(sport2);
		// List<Sport> sportslist=new ArrayList<>();
		// sportslist.add(sport);
		// sportslist.add(sport2);
		// entraineur.setSports(sportslist);
		//// entraineurService.add(entraineur);
		// System.out.println(entraineur.getSports().get(0).getNom()+" sport
		// *************************");
		//System.out.println( entraineurService.add(entraineur)+" "+entraineur.getNom()+" ************************");
	}

}
