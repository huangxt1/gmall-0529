package com.atguigu.gmall.manager;

import com.atguigu.gmall.manager.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManagerServiceApplicationTests {
	@Autowired
	UserMapper userMapper;


	@Test
	public void testLogicDelete(){
		userMapper.deleteById(1L);
		System.out.println("删除完成...");
		//以后的所有查询默认都是查未删除的
		for (User user : userMapper.selectList(null)) {
			System.out.println(user);
		}
		;
	}
	@Test
	public void contextLoads() {
		for (User user : userMapper.selectList(null)) {
			System.out.println(user);
		}

		System.out.println("========");


		//要让xml生效一定加上mybatis-plus.mapper-locations=classpath:mapper/*.xml
		User user = new User();
		user.setName("Jack");
		user.setAge(20);
		User userByHaha = userMapper.getUserByHaha(user);
		System.out.println(userByHaha);

	}

}
