package com.lab1.oop.employee;

import java.sql.Date;

public class Certificate {
	 private String id;
	 private String name;
	 private String rank;
	 private Date date;
	 
	public Certificate(String id, String name, String rank, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public Date getDate() {
		return date;
	}
	public void setCertificatedDate(Date date) {
		this.date = date;
	}
	 
	 
}
