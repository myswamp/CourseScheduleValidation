package com.xxx;

import java.util.List;

public class Course {
	private String id;
	private List<String> dependencies;

	public Course(String id, List<String> dependencies) {
		this.id = id;
		this.dependencies = dependencies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}
}
