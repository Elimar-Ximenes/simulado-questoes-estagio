package projeto.simulados.main.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.QuestionType;
import projeto.simulados.main.model.Topic;
import projeto.simulados.main.model.TrueOrFalseQuestion;
import projeto.simulados.main.repository.TopicRepository;
import projeto.simulados.main.repository.TrueOrFalseQuestionRespository;

@Service
public class TrueOrFalseQuestionService{

	static List<String> trueOrFalseQuestionFromSimulate = new ArrayList<>();
	@Autowired
	TrueOrFalseQuestionRespository trueOrFalseQuestionRespository;

	@Autowired
	TopicRepository topicRepository;

	public void save(int id, TrueOrFalseQuestion entity) {
		if (id != 0) {
			entity.setQuestion_id(id);
		}
		trueOrFalseQuestionRespository.save(entity);
	}

	public void delete(int id) {
		TrueOrFalseQuestion question = find(id);
		trueOrFalseQuestionRespository.delete(question);
	}

	public TrueOrFalseQuestion find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<TrueOrFalseQuestion> question = trueOrFalseQuestionRespository.findById(id);

		if (question.isPresent()) {
			return question.get();
		}

		return null;
	}

	//Incluindo parâmetro type para poder salvar tipo da questão
	public void saveQuestionOnTopic(int topic_id, int type, TrueOrFalseQuestion trueOrFalseQuestion) {

		Topic topic = topicRepository.findById(topic_id).get();
		
		QuestionType qType = QuestionType.valueOf(type);
		trueOrFalseQuestion.setTopic(topic);
		trueOrFalseQuestion.setOption(qType.getValor());// Setando opção chamando qType   
		trueOrFalseQuestionRespository.save(trueOrFalseQuestion);
	}

	public void saveQuestionOnSimulate(int question_id) {
		TrueOrFalseQuestion trueOrFalseQuestion = find(question_id);
		trueOrFalseQuestionFromSimulate.add(trueOrFalseQuestion.getQuestion_id() + ")" + trueOrFalseQuestion.getQuestion());
	}

	public void removeQuestionFromSimulate(int question_id) {
		TrueOrFalseQuestion trueOrFalseQuestion = find(question_id);
		String question1 = trueOrFalseQuestion.getQuestion_id() + ")" + trueOrFalseQuestion.getQuestion();
		trueOrFalseQuestionFromSimulate.remove(question1);
		// questionFromSimulate.remove(question.getQuestion());
	}

	public void removeAllQuestionFromSimulate() {
		trueOrFalseQuestionFromSimulate.clear();
	}

	public List<TrueOrFalseQuestion> findAll() {
		return trueOrFalseQuestionRespository.findAll();
	}

	public List<String> printSimulate() {
		return trueOrFalseQuestionFromSimulate;
	}

	public List<TrueOrFalseQuestion> findTrueOrFalseQuestionsByTopic(String topic_name) { // TODO
		int topic_id = topicRepository.findTopicIdByName(topic_name);
        return trueOrFalseQuestionRespository.findTrueOrFalseQuestionByTopicId(topic_id);
	}
}

