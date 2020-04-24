package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.takeout.mapper.UserMapper;
import com.takeout.pojo.User;

public class UserMapperTest {
	private ApplicationContext context;
	private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		System.out.println("context:"+context);
		userMapper = (UserMapper) context.getBean("userMapper");
	}

	

	@Test
	public void testSelectByPrimaryKey() {
		User user = userMapper.selectByPrimaryKey(1002);
		System.out.println(user);
		System.out.println(user.getNicname());
	}

}
