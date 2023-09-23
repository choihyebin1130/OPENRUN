package com.openrun.ticket.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	final static public int USER_ACCOUNT_ALREADY_EXIST = 0;
	final static public int USER_ACCOUNT_CREATE_SUCCESS = 1;
	final static public int USER_ACCOUNT_CREATE_FAIL = -1;
	
	//구매자 회원가입
	public int createUserAccountConfirm(UserVo userVo) {
		System.out.println("[UserService] createUserAccountConfirm()");
			
		boolean isMember = userDao.isUserMember(userVo.getU_id());
		
		if (!isMember) {
			int result = userDao.insertUserAccount(userVo);
				
			if (result > 0)
				return USER_ACCOUNT_CREATE_SUCCESS;
				
			else
				return USER_ACCOUNT_CREATE_FAIL;
				
		} else {
			return USER_ACCOUNT_ALREADY_EXIST;	
		}
	}
}
