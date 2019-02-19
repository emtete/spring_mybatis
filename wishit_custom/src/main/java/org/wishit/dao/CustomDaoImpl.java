package org.wishit.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wishit.domain.AccountVO;
import org.wishit.domain.CustomVO;
import org.wishit.mapper.AccountMapper;
import org.wishit.mapper.CustomMapper;

import lombok.Setter;

@Repository
public class CustomDaoImpl implements CustomDao {

	
	@Setter( onMethod_ = @Autowired )
	private CustomMapper customMapper;
	
	@Setter( onMethod_ = @Autowired )
	private AccountMapper accountMapper;
	
	
	
	@Override
	public Map<String, Object> getList() {
		
		Map map = new HashMap<String, Object>();
		map.put("custom", customMapper.getList());
		map.put("account", accountMapper.getList());
		
		
		return map;
	}

	
	@Override
	public Map<String, Object> get(String busiNum) {
		
		Map map = new HashMap<String, Object>();
		map.put("custom", customMapper.get(busiNum));
		map.put("account", accountMapper.get(busiNum));
		
		return map;
	}

	@Override
	public void insert(Map map) {
		
		CustomVO custom = (CustomVO)map.get("custom");
		AccountVO account = (AccountVO)map.get("account");
		
		customMapper.insert( custom );
		accountMapper.insert( account );
		
	}

	@Override
	public boolean update(Map map) {
		
		int isCmUpdate = customMapper.update( (CustomVO)map.get("custom") );
		int isAmUpdate = accountMapper.update( (AccountVO)map.get("account") );
		
		boolean isSuccess = ( isCmUpdate == 1 && isAmUpdate == 1 ) ? true : false;  
		
		return isSuccess;
	}

	@Override
	public boolean delete(String busiNum) {

		int isAmDelete = accountMapper.delete(busiNum);
		int isCmDelete = customMapper.delete(busiNum);
		
		boolean isSuccess = ( isCmDelete == 1 && isAmDelete == 1 ) ? true : false;
		
		return isSuccess;
	}

	
}
