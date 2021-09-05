package priv.zhenwen.bookcrossing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("priv.zhenwen.bookcrossing.project.mapper")
public class BookcrossingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookcrossingApplication.class, args);
    }

}
