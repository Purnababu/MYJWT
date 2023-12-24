package com.example.JWTPRACTICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.JWTPRACTICE.entity.User;
import com.example.JWTPRACTICE.repo.Rolerepo;
import com.example.JWTPRACTICE.repo.Userrepo;

@SpringBootApplication
public class JwtPracticeApplication implements CommandLineRunner {

	@Autowired
	private Userrepo userrepo;

	@Autowired
	private Rolerepo rolerepo;



//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder; // Inject the bean here

    public static void main(String[] args) {
        SpringApplication.run(JwtPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setId(1L);
        user.setFirstname("purna");
        user.setPhoneNo("98789789");
        user.setUsername("purna");
//        user.setPassword(this.bCryptPasswordEncoder.encode("purna"));

        // Now you can use the userrepo to save the user
        this.userrepo.save(user);
    }


}
