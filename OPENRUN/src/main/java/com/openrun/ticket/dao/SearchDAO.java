package com.openrun.ticket.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.openrun.ticket.vo.SearchVO;

public interface SearchDAO {

	public List<SearchVO> searchContentsByTitle(String searchKeyword) throws DataAccessException;
}


