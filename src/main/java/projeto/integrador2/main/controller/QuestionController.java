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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projeto.integrador2.main.model.Question;
import projeto.integrador2.main.service.QuestionService;

@RestController
@RequestMapping(path = "/api/questions")
public class QuestionController {

	@Autowired
	QuestionService service;

	@GetMapping(path = "/simulate")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<List<String>> findQuestionsFromSimulate() {
		return new ResponseEntity<List<String>>(service.printSimulate(), HttpStatus.OK);
	}

	@GetMapping
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<List<Question>> findAll() {
		return new ResponseEntity<List<Question>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<Question> find(@PathVariable("id") int id) {
		return new ResponseEntity<Question>(service.find(id), HttpStatus.OK);
	}

	@GetMapping(path = "/searchQuestionByTopic")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<List<Question>> find(@RequestParam("name") String name) {
		return new ResponseEntity<List<Question>>(service.findQuestionByTopic(name), HttpStatus.OK);
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

	/*
	 * @PostMapping public void save(@RequestBody Question question) {
	 * service.save(0, question); }
	 */

	@PostMapping("/topics/{id}")
	//@PreAuthorize("hasAuthority('PROFESSOR')")
	public void save(@PathVariable("id") int topic_id, @RequestBody Question question) {
		service.saveQuestionOnTopic(topic_id, question);
	}

	@PutMapping(path = "{id}")
	//@PreAuthorize("hasAuthority('PROFESSOR')")
	public void update(@PathVariable("id") int id, @RequestBody Question question) {
		service.save(id, question);
	}

	@PostMapping("/{id}/simulate")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public void saveOnSimulate(@PathVariable("id") int question_id) {
		service.saveQuestionOnSimulate(question_id);
	}

	@DeleteMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

	@DeleteMapping(path = "{id}/simulate")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public void deleteQuestionFromSimulate(@PathVariable("id") int id) {
		service.removeQuestionFromSimulate(id);
	}

	@DeleteMapping(path = "/simulate")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public void deleteAllQuestionFromSimulate() {
		service.removeAllQuestionFromSimulate();
	}

}
