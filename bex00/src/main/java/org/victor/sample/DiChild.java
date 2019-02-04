package org.victor.sample;

import org.springframework.stereotype.Component;

@Component
public class DiChild {
	
	private String name;
	private int age;
	
	public DiChild() {
		name="hanul";
		age=31;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "DiChild [name=" + name + ", age=" + age + "]";
	}
	
	
	
	

}
