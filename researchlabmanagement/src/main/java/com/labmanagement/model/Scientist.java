package com.labmanagement.model;

public class Scientist {
	
	private String scientistId;
    private String scientistName;
    private int age;
    private String gender;
    private String researchId;
    private String reportingScientistId;
    
    //Constructor
	public Scientist(String scientistId, String scientistName) {
		super();
		this.scientistId = scientistId;
		this.scientistName = scientistName;
	}

	public String getScientistId() {
		return scientistId;
	}

	public void setScientistId(String scientistId) {
		this.scientistId = scientistId;
	}

	public String getScientistName() {
		return scientistName;
	}

	public void setScientistName(String scientistName) {
		this.scientistName = scientistName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getResearchId() {
		return researchId;
	}

	public void setResearchId(String researchId) {
		this.researchId = researchId;
	}

	public String getReportingScientistId() {
		return reportingScientistId;
	}

	public void setReportingScientistId(String reportingScientistId) {
		this.reportingScientistId = reportingScientistId;
	}

	@Override
	public String toString() {
		return "Scientist [scientistId=" + scientistId + ", scientistName=" + scientistName + ", age=" + age
				+ ", gender=" + gender + ", researchId=" + researchId + ", reportingScientistId=" + reportingScientistId
				+ "]";
	}
	
	
    
    
}
