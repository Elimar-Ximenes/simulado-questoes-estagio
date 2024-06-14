package projeto.simulados.main.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.simulados.main.model.TrueOrFalseQuestion;

public interface TrueOrFalseQuestionRespository extends JpaRepository<TrueOrFalseQuestion, Integer> {
	@Query("SELECT tfq FROM TrueOrFalseQuestion tfq JOIN tfq.topic t WHERE t.topic_id = ?1")
	//@Query(value = "select * from TrueOrFalseQuestion where topic_id = ?1", nativeQuery = true)
	public List <TrueOrFalseQuestion> findTrueOrFalseQuestionByTopicId(int topic_id);

	@Query(value = "select student_id from multiple_choice_question where question_id = ?1", nativeQuery = true)
	public int findStudentIdByMultipleChoiceQuestionId(int question_id);
	
	@Query(value = "select * from TrueOrFalseQuestion where question_id = ?1", nativeQuery = true)
	public TrueOrFalseQuestion findTrueOrFalseQuestionById(int id);
}
