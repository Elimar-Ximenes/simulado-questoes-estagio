package projeto.simulados.main.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.simulados.main.model.OpenEndedQuestion;

public interface OpenEndedQuestionRepository extends JpaRepository<OpenEndedQuestion, Integer> {
	@Query(value = "select * from openEndedQuestion where topic_id = ?1", nativeQuery = true)
	public List <OpenEndedQuestion> findOpenEndedQuestionsByTopicId(int topic_id);

	@Query(value = "select student_id from OpenEndedQuestion where question_id = ?1", nativeQuery = true)
	public int findStudentIdByOpenEndedQuestionId(int question_id);
	
	@Query(value = "select * from openEndedQuestion where question_id = ?1", nativeQuery = true)
	public OpenEndedQuestion findOpenEndedQuestionById(int id);
}
