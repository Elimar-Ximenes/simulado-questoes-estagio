package projeto.simulados.main.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.MultipleChoiceQuestion;
import projeto.simulados.main.model.QuestionType;
import projeto.simulados.main.model.Topic;
import projeto.simulados.main.repository.MultipleChoiceQuestionRepository;
import projeto.simulados.main.repository.TopicRepository;

@Service
public class MultipleChoiceQuestionService{

	static List<String> multipleChoiceQuestionFromSimulate = new ArrayList<>();
	@Autowired
	MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;

	@Autowired
	TopicRepository topicRepository;

	public void save(int id, MultipleChoiceQuestion entity) {
		if (id != 0) {
			entity.setQuestion_id(id);
		}
		multipleChoiceQuestionRepository.save(entity);
	}

	public void delete(int id) {
		MultipleChoiceQuestion question = find(id);
		multipleChoiceQuestionRepository.delete(question);
	}

	public MultipleChoiceQuestion find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<MultipleChoiceQuestion> question = multipleChoiceQuestionRepository.findById(id);

		if (question.isPresent()) {
			return question.get();
		}

		return null;
	}

	//Incluindo parâmetro type para poder salvar tipo da questão
	public void saveQuestionOnTopic(int topic_id, int type, MultipleChoiceQuestion multipleChoiceQuestion) {

		Topic topic = topicRepository.findById(topic_id).get();
		
		QuestionType qType = QuestionType.valueOf(type);
		multipleChoiceQuestion.setTopic(topic);
		multipleChoiceQuestion.setOption(qType.getValor());// Setando opção chamando qType   
		multipleChoiceQuestionRepository.save(multipleChoiceQuestion);
	}

	public void saveQuestionOnSimulate(int question_id) {
		MultipleChoiceQuestion multipleChoiceQuestion = find(question_id);
		multipleChoiceQuestionFromSimulate.add(multipleChoiceQuestion.getQuestion_id() + ")" + multipleChoiceQuestion.getQuestion());
	}

	public void removeQuestionFromSimulate(int question_id) {
		MultipleChoiceQuestion multipleChoiceQuestion = find(question_id);
		String question1 = multipleChoiceQuestion.getQuestion_id() + ")" + multipleChoiceQuestion.getQuestion();
		multipleChoiceQuestionFromSimulate.remove(question1);
		// questionFromSimulate.remove(question.getQuestion());
	}

	public void removeAllQuestionFromSimulate() {
		multipleChoiceQuestionFromSimulate.clear();
	}

	public List<MultipleChoiceQuestion> findAll() {
		return multipleChoiceQuestionRepository.findAll();
	}

	public List<String> printSimulate() {
		return multipleChoiceQuestionFromSimulate;
	}

	public List<MultipleChoiceQuestion> findMultipleChoiceQuestionsByTopic(String topic_name) { // TODO
		int topic_id = topicRepository.findTopicIdByName(topic_name);
        return multipleChoiceQuestionRepository.findMultipleChoiceQuestionsByTopicId(topic_id);
	}

}
