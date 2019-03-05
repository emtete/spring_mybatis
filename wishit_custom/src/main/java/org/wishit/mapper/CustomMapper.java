package org.wishit.mapper;

import java.util.List;

import org.wishit.domain.CustomVO;

public interface CustomMapper {

	public String getTime2();
	public List<CustomVO> getList(CustomVO custom);
	public CustomVO get(String busiNum);
	public void insert(CustomVO custom);
//	public CustomVO insertSelectKey();
	public int update(CustomVO custom);
	public int delete(String busiNum);
	
	
}
