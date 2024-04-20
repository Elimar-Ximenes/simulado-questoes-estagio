package projeto.simulados.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.simulados.main.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
	@Query(value = "select topic_id from topic where name = ?1", nativeQuery = true)
	public int findTopicIdByName(String name);
}
