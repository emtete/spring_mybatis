package org.victor.sample;

import org.apache.ibatis.annotations.Select;

public interface SampleMapper {

	@Select("SELECT curdate()")
	public String getTime();
	
	public String getTime2();
}
