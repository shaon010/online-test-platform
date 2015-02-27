package org.otp.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Quiz {

	@Id
	@GeneratedValue
	private Integer id;

	private String title;
    private boolean active=true;

    @Column(name = "start_date",columnDefinition="DATE")
	private String startDate;
	
	@Column(name = "end_date", columnDefinition="DATE")
	private String endDate;

	private int duration;
	private double point;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.REMOVE)
	private List<Mcq> mcqList;
	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.REMOVE)
	private List<ShortQue> sqList;
	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.REMOVE)
	private List<TF> tfList;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Mcq> getMcqList() {
		return mcqList;
	}

	public void setMcqList(List<Mcq> mcqList) {
		this.mcqList = mcqList;
	}

	public List<ShortQue> getSqList() {
		return sqList;
	}

	public void setSqList(List<ShortQue> sqList) {
		this.sqList = sqList;
	}

	public List<TF> getTfList() {
		return tfList;
	}

	public void setTfList(List<TF> tfList) {
		this.tfList = tfList;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
