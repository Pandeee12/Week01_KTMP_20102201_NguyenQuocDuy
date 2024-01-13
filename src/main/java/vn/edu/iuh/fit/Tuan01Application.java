package vn.edu.iuh.fit;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.ProductRepository;
import vn.edu.iuh.fit.repositories.UserRepository;

import java.util.Locale;
import java.util.Random;

@SpringBootApplication
public class Tuan01Application {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(Tuan01Application.class, args);
	}

	@Bean
	CommandLineRunner test(){
		return args -> {
			Faker faker = new Faker(new Locale("vi","VN"));
			Random random = new Random();

			for (int i = 0; i < 10; i++) {
				User user = new User(faker.name().name());
				userRepository.save(user);

				Product product = new Product(faker.name().name(), random.nextDouble(10000, 100000000));
				productRepository.save(product);
			}

		};
	}
}
