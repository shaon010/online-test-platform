package org.otp.entity;


import javax.persistence.*;
import java.util.List;


@Entity
public class Result {

	@Id
	@GeneratedValue
	private Integer id;
	private double obtainedMarks;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

    @ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(double obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
