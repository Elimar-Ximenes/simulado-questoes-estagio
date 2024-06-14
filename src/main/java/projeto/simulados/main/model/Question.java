package projeto.simulados.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_generator")
	@SequenceGenerator(name = "question_generator", sequenceName = "question_seq", allocationSize = 1)
	@Column(name = "question_id")
	private int question_id;
	@Column(name = "question")
	private String question;
	@Column(name = "option")
	private int option;

	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private Teacher teacher;

	@ManyToOne
	@JoinColumn(name = "topic_id")
	@JsonIgnore
	private Topic topic;


	@OneToOne(mappedBy = "question")
	private Answer answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int question_id, String question, int option, Teacher teacher, Topic topic,
			Answer answer) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.option = option;
		this.teacher = teacher;
		this.topic = topic;
		this.answer = answer;
	}

	public Question(int question_id, String question) {
		super();
		this.question = question;
		this.question_id = question_id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question=" + question + ", option=" + option
				+ ", teacher=" + teacher + ", topic=" + topic + ", answer="
				+ answer + "]";
	}

}
