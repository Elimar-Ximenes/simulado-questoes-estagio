package projeto.integrador2.main.service;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.integrador2.main.model.Question;
import projeto.integrador2.main.model.Topic;
import projeto.integrador2.main.repository.QuestionRepository;
import projeto.integrador2.main.repository.TopicRepository;

@Service
public class QuestionService {

	static List<String> questionFromSimulate = new ArrayList<>();
	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	TopicRepository topicRepository;

	public void save(int id, Question entity) {
		if (id != 0) {
			entity.setQuestion_id(id);
		}
		questionRepository.save(entity);

	}

	public void delete(int id) {
		Question question = find(id);
		questionRepository.delete(question);
	}

	public Question find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<Question> question = questionRepository.findById(id);

		if (question.isPresent()) {
			return question.get();
		}

		return null;
	}

	public void saveQuestionOnTopic(int topic_id, Question question) {

		Topic topic = topicRepository.findById(topic_id).get();

		question.setTopic(topic);

		questionRepository.save(question);
	}

	public void saveQuestionOnSimulate(int question_id) {
		// Question question = questionRepository.findNameQuestionById(question_id);
		Question question = find(question_id);
		questionFromSimulate.add(question.getQuestion_id() + ")" + question.getQuestion());
	}

	public void removeQuestionFromSimulate(int question_id) {
		Question question = find(question_id);
		String question1 = question.getQuestion_id() + ")" + question.getQuestion();
		questionFromSimulate.remove(question1);
		// questionFromSimulate.remove(question.getQuestion());
	}

	public void removeAllQuestionFromSimulate() {
		questionFromSimulate.clear();
	}

	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	public List<String> printSimulate() {
		return questionFromSimulate;
	}

	public List<Question> findQuestionByTopic(String topic_name) { // TODO
		int topic_id = topicRepository.findTopicIdByName(topic_name);
		return questionRepository.findQuestionByTopicId(topic_id);

	}

}
