package projeto.simulados.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.Answer;
import projeto.simulados.main.model.Question;
import projeto.simulados.main.repository.AnswerRepository;
import projeto.simulados.main.repository.QuestionRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	QuestionRepository questionRepository;

	public void save(int id, Answer answer) {
		if (id != 0) {
			Question question = new Question();
			question.setQuestion_id(answerRepository.findQuestionById(id));
			answer.setQuestion(question);
			answer.setAnswer_id(id);
		}
		answerRepository.save(answer);
	}

	public void delete(int id) {
		Answer answer = find(id);
		answerRepository.delete(answer);
	}

	public Answer find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<Answer> answer = answerRepository.findById(id);

		if (answer.isPresent()) {
			return answer.get();
		}

		return null;
	}

	public void saveAnswerOnQuestion(int question_id, Answer answer) {

		Question question = questionRepository.findById(question_id).get();

		answer.setQuestion(question);

		answerRepository.save(answer);
	}

}
