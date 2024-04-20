package projeto.integrador2.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.integrador2.main.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
	@Query(value = "select topic_id from topic where name = ?1", nativeQuery = true)
	public int findTopicIdByName(String name);
}
