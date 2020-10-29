package kr.co.fastcampus.cli;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Main {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dao.xml");
		Dao dao = ctx.getBean("dao", Dao.class); // Dao Ŭ������ xml ���� ã�� �Ҵ��Ѵ�.
		dao.run();
	}
}