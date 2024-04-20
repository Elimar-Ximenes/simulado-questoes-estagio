package projeto.integrador2.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_generator")
	@SequenceGenerator(name = "answer_generator", sequenceName = "answer_seq", allocationSize = 1)
	@Column(name = "answer_id")
	int answer_id;
	@Column(name = "fullAnswer")
	private String fullAnswer;

	@OneToOne
	@JoinColumn(name = "question_id", unique = true)
	@JsonIgnore
	private Question question;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int answer_id, String fullAnswer, Question question) {
		super();
		this.answer_id = answer_id;
		this.fullAnswer = fullAnswer;
		this.question = question;
	}

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public String getFullAnswer() {
		return fullAnswer;
	}

	public void setFullAnswer(String fullAnswer) {
		this.fullAnswer = fullAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [answer_id=" + answer_id + ", fullAnswer=" + fullAnswer + ", question=" + question + "]";
	}

}
