package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	//implements WebMvcConfigurer 해야함
//	@Override
//	public Validator getValidator() { //global 하게 적용
//		return new ItemValidator();
//	}

}
