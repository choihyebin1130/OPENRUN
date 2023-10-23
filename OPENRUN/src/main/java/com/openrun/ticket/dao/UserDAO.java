package com.openrun.ticket.dao;

import java.util.List;

import com.openrun.ticket.vo.UserVO;

public interface UserDAO {
	public List<UserVO> user() throws Exception;
	public void insertUser(UserVO userVO) throws Exception;
	public int idCheck(String u_id);
	public UserVO Login(UserVO userVO);
	public UserVO findIdCheck(UserVO userVO);
	public UserVO findPwCheck(UserVO userVO);
	public String pwChange(UserVO userVO);
}
