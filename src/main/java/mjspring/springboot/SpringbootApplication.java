package mjspring.springboot;

import mjspring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class SpringbootApplication {

//	@Bean
//	ApplicationRunner applicationRunner(Environment env) {
//		return args -> {
//			String name = env.getProperty("my.name");
//			System.out.println("my.name : " + name);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}


}
