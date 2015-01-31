package org.otp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubmittedAnsShortQue {

	@Id
	@GeneratedValue
	private Integer id;
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "sq_id")
	private ShortQue sq;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Users user;
	

	public ShortQue getSq() {
		return sq;
	}

	public void setSq(ShortQue sq) {
		this.sq = sq;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

		public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
