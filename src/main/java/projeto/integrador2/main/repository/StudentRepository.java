package projeto.integrador2.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.integrador2.main.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(value = "select * from student where email = ?1", nativeQuery = true)
	Student recoveryCredentials(String email);
	/*@Query(value = "select * from teachers where email = ?1 and id=?2", nativeQuery = true)
	Teacher recoveryCredentials(String email, int id);*/
	@Query(value = "select answer_secret_ask from student where answer_secret_ask = ?1", nativeQuery = true)
	public String findAnswerBySecretAnswer(String secretAnswer);
	
	@Query(value = "select id from student where answer_secret_ask = ?1", nativeQuery = true)
	public int findIdBySecretAnswer(String secretAnswer);

	@Query(value = "select email from student where id = ?1", nativeQuery = true)
	public String findEmailById(int id);
	
	@Query(value = "select id from student where id = ?1", nativeQuery = true)
	public int findIdById(int id);
}
