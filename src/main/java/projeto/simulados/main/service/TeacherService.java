package projeto.simulados.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.Teacher;
import projeto.simulados.main.repository.LoginRepository;
import projeto.simulados.main.repository.QuestionRepository;
import projeto.simulados.main.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	QuestionService questionService;

	@Autowired
	LoginRepository loginRepository;

	public void save(int id, Teacher entity) {
		if (id != 0) {
			entity.setUser_id(id);
		}
		teacherRepository.save(entity);
	}

	public void delete(int id) {
		Teacher teacher = find(id);
		teacherRepository.delete(teacher);
	}

	public Teacher find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<Teacher> teacher = teacherRepository.findById(id);

		if (teacher.isPresent()) {
			return teacher.get();
		}

		return null;
	}

	public Teacher recoveryCredentials(String email) { // TODO
		return teacherRepository.recoveryCredentials(email);
	}

	public String findAnswerBySecretAnswer(String answerSecretAnswer) {
		return teacherRepository.findAnswerBySecretAnswer(answerSecretAnswer);
	}
	
	public int findIdBySecretAnswer(String answerSecretAnswer) {
		return teacherRepository.findIdBySecretAnswer(answerSecretAnswer);
	}

	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}
}