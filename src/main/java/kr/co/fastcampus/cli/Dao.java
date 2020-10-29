package kr.co.fastcampus.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dao {

	/*
	 * 2. static factory method
	 * 
	 * public static Dao createDao() { return new Dao(); }
	 * 
	 */
	private Connection connection;

	public Dao(Connection connection) {
		this.connection = connection;
	}

	public void run() throws SQLException {
		Statement statement = connection.createStatement();
		connection.setAutoCommit(false);
		statement.execute("create table member(" + "id int auto_increment, username varchar(255) not null,"
				+ "password varchar(255) not null," + "primary key(id))");

		try {
			statement.executeUpdate("insert into member(username, password) values('kyunghun','1234')");
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
		}
		ResultSet resultSet = statement.executeQuery("select id, username, password from member;");
		while (resultSet.next()) {
			// Member member = new Member(resultSet);
			Member member = new Member("kyunghun", "1234");
			log.info(member.toString());
			log.info(member.getUsername());
		}

	}
}
