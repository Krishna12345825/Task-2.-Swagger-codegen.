package com.kaiburr.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

	@Id
	private String id; // fixed name
	private String actorname;
	private String category;
	private Long mobileNo;

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(String id, String actorname, String category, Long mobileNo) {
		super();
		this.id = id;
		this.actorname = actorname;
		this.category = category;
		this.mobileNo = mobileNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActorname() {
		return actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

}
