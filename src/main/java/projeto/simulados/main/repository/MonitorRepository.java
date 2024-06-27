package projeto.simulados.main.repository;

import projeto.simulados.main.model.Monitor;


import org.springframework.data.jpa.repository.JpaRepository;


public interface MonitorRepository extends JpaRepository<Monitor, Integer> {
	
}
