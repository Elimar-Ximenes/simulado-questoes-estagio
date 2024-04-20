package projeto.integrador2.main.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "student", schema = "public")
public class Student extends User {

	@ManyToMany
	@JoinTable(name = "denounced_questions", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
	private List<Question> denouncedQuestions;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int user_id, String name, String login, String password, String function, String email,
			String secretAsk, String answerSecretAsk) {
		super(user_id, name, login, password, function, email, secretAsk, answerSecretAsk);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getUser_id() {
		// TODO Auto-generated method stub
		return super.getUser_id();
	}

	@Override
	public void setUser_id(int user_id) {
		// TODO Auto-generated method stub
		super.setUser_id(user_id);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}

	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		super.setLogin(login);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getFunction() {
		// TODO Auto-generated method stub
		return super.getFunction();
	}

	@Override
	public void setFunction(String function) {
		// TODO Auto-generated method stub
		super.setFunction(function);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getSecretAsk() {
		// TODO Auto-generated method stub
		return super.getSecretAsk();
	}

	@Override
	public void setSecretAsk(String secretAsk) {
		// TODO Auto-generated method stub
		super.setSecretAsk(secretAsk);
	}

	@Override
	public String getAnswerSecretAsk() {
		// TODO Auto-generated method stub
		return super.getAnswerSecretAsk();
	}

	@Override
	public void setAnswerSecretAsk(String answerSecretAsk) {
		// TODO Auto-generated method stub
		super.setAnswerSecretAsk(answerSecretAsk);
	}

	public List<Question> getDenouncedQuestions() {
		return denouncedQuestions;
	}

	public void setDenouncedQuestions(List<Question> denouncedQuestions) {
		this.denouncedQuestions = denouncedQuestions;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + getDenouncedQuestions();
	}
}
