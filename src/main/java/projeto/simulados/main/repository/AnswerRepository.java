package projeto.simulados.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.simulados.main.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	@Query(value = "select question_id from answer where answer_id = ?1", nativeQuery = true)
	public int findQuestionById(int id);
	
	@Query(value = "select * from answer where question_id = ?1", nativeQuery = true)
	public Answer findAnswerById(int id);
}
