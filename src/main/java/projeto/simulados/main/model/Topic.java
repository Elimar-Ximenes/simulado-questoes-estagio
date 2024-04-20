package projeto.simulados.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "topic_id")
	private int topic_id;
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "topic")
	private List<Question> question;

	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private Teacher teacher;

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(int topic_id, String name, List<Question> question, Teacher teacher) {
		super();
		this.topic_id = topic_id;
		this.name = name;
		this.question = question;
		this.teacher = teacher;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Topic [topic_id=" + topic_id + ", name=" + name + ", question=" + question + ", teacher=" + teacher
				+ "]";
	}

}
