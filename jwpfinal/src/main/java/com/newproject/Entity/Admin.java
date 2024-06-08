package com.newproject.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {

		Admin other = (Admin) obj;
		if (Objects.equals(name, other.name) && Objects.equals(password, other.password)) {
			return true;
		} else {
			return false;
		}
	}

}
