package org.wishit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wishit.domain.CustomVO;
import org.wishit.mapper.CustomMapper;

import lombok.Setter;


public interface CustomDao {
	
	public List<CustomVO> getList(CustomVO custom);
	public CustomVO get(String busiNum);
	public void insert(Map map);
	public boolean update(Map map);
	public boolean delete(String busiNum);
}
