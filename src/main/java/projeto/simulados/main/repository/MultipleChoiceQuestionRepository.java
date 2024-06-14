package projeto.simulados.main.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.simulados.main.model.MultipleChoiceQuestion;

public interface MultipleChoiceQuestionRepository extends JpaRepository<MultipleChoiceQuestion, Integer> {
	@Query("SELECT mcq FROM MultipleChoiceQuestion mcq JOIN mcq.topic t WHERE t.topic_id = ?1")
	//@Query(value = "select * from multiple_choice_question where topic_id = ?1", nativeQuery = true)
	public List <MultipleChoiceQuestion> findMultipleChoiceQuestionsByTopicId(int topic_id);

	@Query(value = "select student_id from multiple_choice_question where question_id = ?1", nativeQuery = true)
	public int findStudentIdByMultipleChoiceQuestionId(int question_id);
	
	@Query(value = "select * from multiple_choice_question where question_id = ?1", nativeQuery = true)
	public MultipleChoiceQuestion findMultipleChoiceQuestionById(int id);
}

