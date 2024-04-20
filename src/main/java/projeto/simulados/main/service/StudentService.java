package projeto.simulados.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.Login;
import projeto.simulados.main.model.Question;
import projeto.simulados.main.model.Student;
import projeto.simulados.main.repository.LoginRepository;
import projeto.simulados.main.repository.QuestionRepository;
import projeto.simulados.main.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	QuestionService questionService;

	@Autowired
	LoginRepository loginRepository;

	public void save(int id, Student entity) {
		if (id != 0) {
			entity.setUser_id(id);
			entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
		}
		entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
		studentRepository.save(entity);
	}

	public void delete(int id) {
		Student student = find(id);
		studentRepository.delete(student);
	}

	public Student find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<Student> student = studentRepository.findById(id);

		if (student.isPresent()) {
			return student.get();
		}

		return null;
	}

	public Login findLogin(int id) {
		if (id < 1) {
			return null;
		}

		Optional<Login> login = loginRepository.findById(id);

		if (login.isPresent()) {
			return login.get();
		}

		return null;
	}

	public Student recoveryCredentials(String email) { // TODO
		return studentRepository.recoveryCredentials(email);
	}

	public String findAnswerBySecretAnswer(String answerSecretAnswer) {
		return studentRepository.findAnswerBySecretAnswer(answerSecretAnswer);
	}

	public int findIdBySecretAnswer(String answerSecretAnswer) {
		return studentRepository.findIdBySecretAnswer(answerSecretAnswer);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public void includeQuestionDenouncedList(int question_id, int student_id) {

		Student student = find(student_id);
		Question question = questionRepository.findQuestionById(question_id);

		List<Question> questions = new ArrayList<>();
		questions.add(question);
		student.setDenouncedQuestions(questions);

		studentRepository.save(student);
	}

}
