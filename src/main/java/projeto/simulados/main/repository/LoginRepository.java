package projeto.simulados.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.simulados.main.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	Login findByEmail(String email);
	
	@Query(value = "select * from login where email = ?1", nativeQuery = true)
	public Login findLoginByEmail(String email);

}
