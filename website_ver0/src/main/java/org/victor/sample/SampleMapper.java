package org.victor.sample;

import org.apache.ibatis.annotations.Select;

public interface SampleMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
}
