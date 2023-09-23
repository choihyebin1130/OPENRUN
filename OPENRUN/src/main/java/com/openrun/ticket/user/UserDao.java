package com.openrun.ticket.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	//회원가입
	public boolean isUserMember(String u_id) {
		System.out.println("[UserDao] isUserMember()");
		
		String sql =  "SELECT COUNT(*) FROM tbl_user "
					+ "WHERE u_id = ?";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, u_id);
		
		return result > 0 ? true : false;
		
	}

	public int insertUserAccount(UserVo userVo) {
		System.out.println("[UserDao] insertUserAccount()");
		
		String sql = "INSERT INTO tbl_user(u_id, "
											   + "u_pw, "
											   + "u_name, "
											   + "u_birth, "
											   + "u_address, "
											   + "u_phone, "
											   + "u_email, "
											   + "u_bank_name,"
											   + "u_account_no,"
											   + "u_join_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql, 
											 userVo.getU_id(), 
											 passwordEncoder.encode(userVo.getU_pw()), 
											 userVo.getU_name(), 
											 userVo.getU_birth(), 
											 userVo.getU_address(), 
											 userVo.getU_phone(), 
											 userVo.getU_email(), 
											 userVo.getU_bank_name(),
											 userVo.getU_account_no());
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return result;
	}

}
