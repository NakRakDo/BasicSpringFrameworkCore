package kr.co.fastcampus.cli;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor //���ڰ� ���� �������� -> �⺻������
@AllArgsConstructor	// ���ڰ� ��� �޴� ������
@RequiredArgsConstructor //non null ������̼��� ���� �׸� ���ڷ� �޴� ������.
@Getter
@Setter
@ToString
public class Member {
	private int id;
	@NonNull private String username;
	@NonNull private String password;

	public Member(ResultSet rs) {
		try {
			this.id = rs.getInt("id");
			this.username = rs.getString("username");
			this.password = rs.getString("password");
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
