package org.wishit.mapper;

import java.util.List;

import org.wishit.domain.AccountVO;

public interface AccountMapper {
	
	public List<AccountVO> getList();
	public List<AccountVO> get(String busiNum);
	public void insert(AccountVO account);
	public int update(AccountVO account);
	public int delete(String busiNum);
	
}
