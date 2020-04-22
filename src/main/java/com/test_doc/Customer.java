package com.test_doc;

public class Customer {

	private int id;
	private String name;
	private String addr;

	public Customer(int id, String name, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.addr=addr;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

