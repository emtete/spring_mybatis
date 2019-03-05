package org.wishit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wishit.dao.CustomDao;
import org.wishit.domain.CustomVO;

import lombok.Setter;

@Service
public class CustomServiceImpl implements CustomService {

	@Setter( onMethod_ = @Autowired )
	private CustomDao dao;
	
	@Override
	public List<CustomVO> getList(CustomVO custom) {

		return dao.getList(custom);
	}

	@Override
	public CustomVO get(String busiNum) {

		return dao.get(busiNum);
	}

	@Override
	public void insert(Map map) {
		
		dao.insert(map);
	}

	@Override
	public boolean update(Map map) {
		
		return dao.update(map);
	}

	@Override
	public boolean delete(String busiNum) {

		return dao.delete(busiNum);
	}

}
