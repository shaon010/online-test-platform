package org.otp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TF {

	
	@Id
	@GeneratedValue
	private Integer id;

	private String question;
	private String tfOption;

	private String image;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id" )
	private Quiz quiz;
	
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	

	public String getTfOption() {
		return tfOption;
	}

	public void setTfOption(String tfOption) {
		this.tfOption = tfOption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
