package pl.motylpiotr.homebudget;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class HomeBudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBudgetApplication.class, args);

		log.info("####################################");
		log.info("HomeBudget - Application start ");
		log.info("####################################");
	}
}
