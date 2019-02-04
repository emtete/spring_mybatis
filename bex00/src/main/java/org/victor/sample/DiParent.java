package org.victor.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiParent {

	@Autowired
	private DiChild child;
	
	public DiParent() {
	}

	public DiChild getChild() {
		return child;
	}

	public void setChild(DiChild child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "DiParent [child=" + child + "]";
	}
	
	
}
