package fcmtest.androidapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AndroidapiApplication {
	public static void main(String[] args) {

		Hello hello = new Hello();
		hello.setData("testt");
		String data = hello.getData();

		System.out.println("data = " + data);

		SpringApplication.run(AndroidapiApplication.class, args);
	}

}
