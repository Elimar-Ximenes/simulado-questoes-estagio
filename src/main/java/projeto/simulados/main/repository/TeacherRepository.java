package projeto.simulados.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.simulados.main.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

	@Query(value = "select * from teacher where email = ?1", nativeQuery = true)
	Teacher recoveryCredentials(String email);
	/*@Query(value = "select * from teachers where email = ?1 and id=?2", nativeQuery = true)
	Teacher recoveryCredentials(String email, int id);*/
	@Query(value = "select answer_secret_ask from teacher where answer_secret_ask = ?1", nativeQuery = true)
	public String findAnswerBySecretAnswer(String secretAnswer);
	
	@Query(value = "select id from teacher where answer_secret_ask = ?1", nativeQuery = true)
	public int findIdBySecretAnswer(String secretAnswer);
}
