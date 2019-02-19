package org.wishit.sample;

import org.apache.ibatis.annotations.Select;

public interface SampleMapper {

	@Select("SELECT sysdate from dual")
	public String getTime();
	
	public String getTime2();
}
