package org.otp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class SubmittedAnsMcq {

	@Id
	@GeneratedValue
	private Integer id;
	private int checkbox1;
	private int checkbox2;
	private int checkbox3;
	private int checkbox4;
	private int checkbox5;
    private boolean ansState=false; // 1= true, 0 = false


    @ManyToOne
	@JoinColumn(name = "mcq_id")
	private Mcq mcq;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Users user;


    public boolean isAnsState() {
        return ansState;
    }
    public void setAnsState(boolean ansState) {
        this.ansState = ansState;
    }
	public Mcq getMcq() {
		return mcq;
	}

	public void setMcq(Mcq mcq) {
		this.mcq = mcq;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
