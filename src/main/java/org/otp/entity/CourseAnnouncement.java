package org.otp.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
public class CourseAnnouncement {

	@Id
	@GeneratedValue
	private Integer id;

    @Lob
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(length = Integer.MAX_VALUE)
    private String description;
	
	@Column(columnDefinition="TIMESTAMP")
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
