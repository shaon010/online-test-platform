package org.otp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Integer id;
	private String Title;
	private String image;
	
	@Lob
	@Type(type = "org.hibernate.type.StringClobType")
	@Column(length = Integer.MAX_VALUE)
	private String description;
	private String faq1;
	private String faq2;
	private String faq3;
	private String faq4;
	private String faq5;
	private String faq1ans;
	private String faq2ans;
	private String faq3ans;
	private String faq4ans;
	private String faq5ans;
	private boolean active=true;

	@Column(name = "start_date",columnDefinition="DATE")
	private String startDate;
	
	@Column(name = "end_date", columnDefinition="DATE")
	private String endDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "published_date", columnDefinition="TIMESTAMP")//columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	private Date publishedDate;
	
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Users user;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
	private List<CourseStudents> courseStudentList;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
	private List<Quiz> quizList;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
	private List<CourseJoinRequest> courseReqStudentList;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
	private List<CourseAnnouncement> courseAnnouncementList;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public List<CourseAnnouncement> getCourseAnnouncementList() {
		return courseAnnouncementList;
	}
	public void setCourseAnnouncementList(
			List<CourseAnnouncement> courseAnnouncementList) {
		this.courseAnnouncementList = courseAnnouncementList;
	}
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getFaq1ans() {
		return faq1ans;
	}
	public void setFaq1ans(String faq1ans) {
		this.faq1ans = faq1ans;
	}
	public String getFaq2ans() {
		return faq2ans;
	}
	public void setFaq2ans(String faq2ans) {
		this.faq2ans = faq2ans;
	}
	public String getFaq3ans() {
		return faq3ans;
	}
	public void setFaq3ans(String faq3ans) {
		this.faq3ans = faq3ans;
	}
	public String getFaq4ans() {
		return faq4ans;
	}
	public void setFaq4ans(String faq4ans) {
		this.faq4ans = faq4ans;
	}
	public String getFaq5ans() {
		return faq5ans;
	}
	public void setFaq5ans(String faq5ans) {
		this.faq5ans = faq5ans;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFaq1() {
		return faq1;
	}
	public void setFaq1(String faq1) {
		this.faq1 = faq1;
	}
	public String getFaq2() {
		return faq2;
	}
	public void setFaq2(String faq2) {
		this.faq2 = faq2;
	}
	public String getFaq3() {
		return faq3;
	}
	public void setFaq3(String faq3) {
		this.faq3 = faq3;
	}
	public String getFaq4() {
		return faq4;
	}
	public void setFaq4(String faq4) {
		this.faq4 = faq4;
	}
	public String getFaq5() {
		return faq5;
	}
	public void setFaq5(String faq5) {
		this.faq5 = faq5;
	}
		
}
