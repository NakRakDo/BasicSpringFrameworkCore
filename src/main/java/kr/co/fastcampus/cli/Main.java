package kr.co.fastcampus.cli;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Main {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dao.xml");
		Dao dao = ctx.getBean("dao", Dao.class); // Dao 클래스를 xml 에서 찾아 할당한다.
		dao.run();
	}
}