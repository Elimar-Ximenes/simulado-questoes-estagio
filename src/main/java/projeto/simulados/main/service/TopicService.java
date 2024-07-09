package projeto.simulados.main.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.Teacher;
import projeto.simulados.main.model.Topic;
import projeto.simulados.main.repository.TeacherRepository;
import projeto.simulados.main.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	@Autowired
	TeacherRepository teacherRepository;

	public void save(int id, Topic entity) {
		if (id != 0) {
			entity.setTopic_id(id);
		}
		topicRepository.save(entity);
	}

	public void delete(int id) {
		Topic topic = find(id);
		topicRepository.delete(topic);
	}

	public Topic find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<Topic> topic = topicRepository.findById(id);

		if (topic.isPresent()) {
			return topic.get();
		}

		return null;
	}

	public List<Topic> findAll() {
		return topicRepository.findAll();
	}

	public void saveTopicByTeacher(int id, Topic topic) {
		Teacher teacher = teacherRepository.findById(id).get();
		topic.setTeacher(teacher);
		topicRepository.save(topic);
	}

	public void saveTopicOnTeacher(int teacher_id, Topic topic) {
		Teacher teacher = teacherRepository.findById(teacher_id).get();
		topic.setTeacher(teacher);
		topicRepository.save(topic);
	}


}
