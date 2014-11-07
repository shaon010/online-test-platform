package org.otp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.otp.annotation.UniqueUsername;

@Entity
public class Users {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3, message = "Name must be at least 3 characters!")
	private String name;
	
	@Size(min = 1, message = "Please select at least one university")
	private String uvname;
	
	@Size(min = 1, message = "Please select at least one university")
	private String position;

	

	@Size(min = 3, message = "User name must be at least 3 characters!")
	@Column(unique = true)
	@UniqueUsername(message = "Such username already exists!")
	private String username;

	@Size(min = 1, message = "Invalid email address!")
	@Email(message = "Invalid email address!")
	private String email;

	@Size(min = 5, message = "Password must be at least 5 characters!")
	private String password;

	private int enabled;

	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Course> courseList;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<CourseStudents> courseStudentList;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<CourseJoinRequest> courseReqStudentList;
	
	public List<CourseJoinRequest> getCourseReqStudentList() {
		return courseReqStudentList;
	}

	public void setCourseReqStudentList(List<CourseJoinRequest> courseReqStudentList) {
		this.courseReqStudentList = courseReqStudentList;
	}

	public List<CourseStudents> getCourseStudentList() {
		return courseStudentList;
	}

	public void setCourseStudentList(List<CourseStudents> courseStudentList) {
		this.courseStudentList = courseStudentList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public String getUvname() {
		return uvname;
	}

	public void setUvname(String uvname) {
		this.uvname = uvname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
