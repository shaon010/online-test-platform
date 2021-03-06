package org.otp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Mcq {

	@Id
	@GeneratedValue
	private Integer id;

	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String choice5;
	private String imagepath;
	private int checkbox1;
	private int checkbox2;
	private int checkbox3;
	private int checkbox4;
	private int checkbox5;
	
	public int getCheckbox1() {
		return checkbox1;
	}

	public void setCheckbox1(int checkbox1) {
		this.checkbox1 = checkbox1;
	}

	public int getCheckbox2() {
		return checkbox2;
	}

	public void setCheckbox2(int checkbox2) {
		this.checkbox2 = checkbox2;
	}

	public int getCheckbox3() {
		return checkbox3;
	}

	public void setCheckbox3(int checkbox3) {
		this.checkbox3 = checkbox3;
	}

	public int getCheckbox4() {
		return checkbox4;
	}

	public void setCheckbox4(int checkbox4) {
		this.checkbox4 = checkbox4;
	}

	public int getCheckbox5() {
		return checkbox5;
	}

	public void setCheckbox5(int checkbox5) {
		this.checkbox5 = checkbox5;
	}

	@ManyToOne
	@JoinColumn(name = "quiz_id")
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
	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	public String getChoice5() {
		return choice5;
	}

	public void setChoice5(String choice5) {
		this.choice5 = choice5;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
