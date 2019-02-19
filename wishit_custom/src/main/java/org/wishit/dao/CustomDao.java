package org.wishit.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wishit.mapper.CustomMapper;

import lombok.Setter;


public interface CustomDao {
	
	public Map<String, Object> getList();
	public Map<String, Object> get(String busiNum);
	public void insert(Map map);
	public boolean update(Map map);
	public boolean delete(String busiNum);
}
