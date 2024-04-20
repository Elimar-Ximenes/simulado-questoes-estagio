package projeto.integrador2.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.integrador2.main.model.Topic;
import projeto.integrador2.main.service.TopicService;

@RestController
@RequestMapping(path = "/api/topics")
public class TopicController {

	@Autowired
	TopicService service;

	@GetMapping
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<List<Topic>> findAll() {
		return new ResponseEntity<List<Topic>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<Topic> find(@PathVariable("id") int id) {
		return new ResponseEntity<Topic>(service.find(id), HttpStatus.OK);
	}

	/*
	 * @GetMapping(path = "/search") public ResponseEntity<Teacher>
	 * findByName(@RequestParam("name") String name) { Teacher teacher =
	 * service.findByName(name);
	 * 
	 * if(teacher != null) { return new ResponseEntity<Teacher>(teacher,
	 * HttpStatus.OK); } else { return new
	 * ResponseEntity<Teacher>(HttpStatus.NOT_FOUND); } }
	 */

	@PostMapping("/teacher/{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR')")
	public void save(@PathVariable("id") int teacher_id, @RequestBody Topic topic) {
		service.saveTopicOnTeacher(teacher_id, topic);
	}

	@PostMapping
	//@PreAuthorize("hasAnyAuthority('PROFESSOR')")
	public void save(@RequestBody Topic topic) {
		service.save(0, topic);
	}

	@PutMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR')")
	public void update(@PathVariable("id") int id, @RequestBody Topic topic) {
		service.save(id, topic);
	}

	@DeleteMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
}