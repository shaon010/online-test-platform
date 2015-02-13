package org.otp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubmittedAnsTF {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String tfOption;
    private boolean ansState=false; //1=true,0=false

	@ManyToOne
	@JoinColumn(name = "tf_id")
	private TF tf;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Users user;

    public boolean isAnsState() {
        return ansState;
    }

    public void setAnsState(boolean ansState) {
        this.ansState = ansState;
    }

    public TF getTf() {
        return tf;
    }

    public void setTf(TF tf) {
        this.tf = tf;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getTfOption() {
		return tfOption;
	}

	public void setTfOption(String tfOption) {
		this.tfOption = tfOption;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
