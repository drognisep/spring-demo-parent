package com.luv2code.springdemo.mvc.beans;

import java.util.LinkedHashMap;

public class Student {
	private String firstName, lastName, country, favoriteLang;
	private String[] opSystems;
	
	private LinkedHashMap<String,String> 
		countryOptions = new LinkedHashMap<>(),
		languageOptions = new LinkedHashMap<>(),
		opSystemOptions = new LinkedHashMap<>();
	
	public Student() {
		countryOptions.put("US", "United States");
		languageOptions.put("Java", "Java");
		opSystemOptions.put("Windows", "Windows");
		opSystemOptions.put("Linux", "Linux");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFavoriteLang() {
		return favoriteLang;
	}

	public void setFavoriteLang(String favoriteLang) {
		this.favoriteLang = favoriteLang;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public String[] getOpSystems() {
		return opSystems;
	}

	public void setOpSystems(String[] opSystems) {
		this.opSystems = opSystems;
	}

	public LinkedHashMap<String, String> getOpSystemOptions() {
		return opSystemOptions;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", favoriteLang=" + favoriteLang + "]";
	}
}
