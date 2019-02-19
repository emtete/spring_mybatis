package org.wishit.service;

import java.util.Map;

public interface CustomService {
	
	public Map<String, Object> getList();
	public Map<String, Object> get(String busiNum);
	public void insert(Map map);
	public boolean update(Map map);
	public boolean delete(String busiNum);
}
