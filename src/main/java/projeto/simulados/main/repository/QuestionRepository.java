package projeto.simulados.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.simulados.main.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	@Query(value = "select * from question where topic_id = ?1", nativeQuery = true)
	public List <Question> findQuestionByTopicId(int topic_id);

	@Query(value = "select student_id from question where question_id = ?1", nativeQuery = true)
	public int findStudentIdByQuestionId(int question_id);
	
	@Query(value = "select * from question where question_id = ?1", nativeQuery = true)
	public Question findQuestionById(int id);
	
	@Query(value = "select * from question natural join denounced_questions on question_id = question_id where select count(question_id) from denounced_questions < 3", nativeQuery = true)
	public List<Question> findQuestionNotDenounced();
	
		
}
