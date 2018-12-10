package incar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created on 2018/12/6.
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = "incar")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
