package projeto.integrador2.main.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1)
	@Column(nullable = false, unique = true, name = "id")
	private int user_id;
	@Column(name = "name")
	private String name;
	@Column(name = "login")
	private String login;
	@Column(nullable = false, unique = true, name = "password")
	private String password;
	@Column(name = "function")
	private String function;
	@Column(nullable = false, unique = true, name = "email")
	private String email;
	@Column(name = "secretAsk")
	private String secretAsk;
	@Column(name = "answerSecretAsk")
	private String answerSecretAsk;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String name, String login, String password, String function, String email,
			String secretAsk, String answerSecretAsk) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.function = function;
		this.email = email;
		this.secretAsk = secretAsk;
		this.answerSecretAsk = answerSecretAsk;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecretAsk() {
		return secretAsk;
	}

	public void setSecretAsk(String secretAsk) {
		this.secretAsk = secretAsk;
	}

	public String getAnswerSecretAsk() {
		return answerSecretAsk;
	}

	public void setAnswerSecretAsk(String answerSecretAsk) {
		this.answerSecretAsk = answerSecretAsk;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", login=" + login + ", password=" + password
				+ ", function=" + function + ", email=" + email + ", secretAsk=" + secretAsk + ", answerSecretAsk="
				+ answerSecretAsk + "]";
	}

}
