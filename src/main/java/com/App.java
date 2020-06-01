package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// @SpringBootApplication指定这是一个 spring boot的应用程序.
@SpringBootApplication
// 扫描数据访问层接口的包名。
@MapperScan("com.repository")
public class App 
{
public static void main( String[] args )
{
	// SpringApplication 用于从main方法启动Spring应用的类。
	System.out.println(new BCryptPasswordEncoder().encode("a"));
	SpringApplication.run(App.class, args);
	
}
}



/*
 * package com;
 * 
 * import com.pojo.pet; import org.junit.Test; import org.junit.runner.RunWith;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest(classes = petTest.class) public class petTest {
 * 
 * @Autowired pet pet;
 * 
 * @Test public void contextLoads() { System.out.println(pet.toString()); }
 * 
 * }
 */


