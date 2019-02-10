package org.victor.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data
@Component
public class DiParent {

	@Setter( onMethod_ = @Autowired )
	private DiChild child;
}
