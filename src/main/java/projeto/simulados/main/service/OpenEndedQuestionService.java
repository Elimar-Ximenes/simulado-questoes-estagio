package projeto.simulados.main.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.OpenEndedQuestion;
import projeto.simulados.main.model.QuestionType;
import projeto.simulados.main.model.Topic;
import projeto.simulados.main.repository.OpenEndedQuestionRepository;
import projeto.simulados.main.repository.TopicRepository;

@Service
public class OpenEndedQuestionService {

	static List<String> openEndedQuestionFromSimulate = new ArrayList<>();
	@Autowired
	OpenEndedQuestionRepository openEndedQuestionRepository;

	@Autowired
	TopicRepository topicRepository;

	public void save(int id, OpenEndedQuestion entity) {
		if (id != 0) {
			entity.setQuestion_id(id);;
		}
		openEndedQuestionRepository.save(entity);

	}

	public void delete(int id) {
		OpenEndedQuestion question = find(id);
		openEndedQuestionRepository.delete(question);
	}

	public OpenEndedQuestion find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<OpenEndedQuestion> question = openEndedQuestionRepository.findById(id);

		if (question.isPresent()) {
			return question.get();
		}

		return null;
	}

	//Incluindo parâmetro type para poder salvar tipo da questão
	public void saveQuestionOnTopic(int topic_id, int type, OpenEndedQuestion openEndedQuestion) {

		Topic topic = topicRepository.findById(topic_id).get();
		
		QuestionType qType = QuestionType.valueOf(type);
		openEndedQuestion.setTopic(topic);
		openEndedQuestion.setOption(qType.getValor());// Setando opção chamando qType   
		openEndedQuestionRepository.save(openEndedQuestion);
	}

	public void saveQuestionOnSimulate(int question_id) {
		OpenEndedQuestion openEndedQuestion = find(question_id);
		openEndedQuestionFromSimulate.add(openEndedQuestion.getQuestion_id() + ")" + openEndedQuestion.getQuestion());
	}

	public void removeQuestionFromSimulate(int question_id) {
		OpenEndedQuestion openEndedQuestion = find(question_id);
		String question1 = openEndedQuestion.getQuestion_id() + ")" + openEndedQuestion.getQuestion();
		openEndedQuestionFromSimulate.remove(question1);
		// questionFromSimulate.remove(question.getQuestion());
	}

	public void removeAllQuestionFromSimulate() {
		openEndedQuestionFromSimulate.clear();
	}

	public List<OpenEndedQuestion> findAll() {
		return openEndedQuestionRepository.findAll();
	}

	public List<String> printSimulate() {
		return openEndedQuestionFromSimulate;
	}

	public List<OpenEndedQuestion> findOpenEndedQuestionByTopic(String topic_name) { // TODO
		int topic_id = topicRepository.findTopicIdByName(topic_name);
        return openEndedQuestionRepository.findOpenEndedQuestionsByTopicId(topic_id);
	}

}

