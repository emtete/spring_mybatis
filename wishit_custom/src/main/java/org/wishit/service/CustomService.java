package org.wishit.service;

import java.util.List;
import java.util.Map;

import org.wishit.domain.CustomVO;

public interface CustomService {
	
	public List<CustomVO> getList(CustomVO custom);
	public CustomVO get(String busiNum);
	public void insert(Map map);
	public boolean update(Map map);
	public boolean delete(String busiNum);
}
