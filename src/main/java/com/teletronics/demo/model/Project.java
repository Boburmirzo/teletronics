package com.teletronics.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
	private final long id;
	private final String name;
	private final String fullName;
	private final String htmlUrl;
	private final String description;
	
	public Project(long id,
	               String name,
	               String fullName,
	               String htmlUrl,
	               String description) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.htmlUrl = htmlUrl;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @return the htmlUrl
	 */
	public String getHtmlUrl() {
		return htmlUrl;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
}
