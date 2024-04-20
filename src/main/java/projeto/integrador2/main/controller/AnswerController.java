package projeto.integrador2.main.controller;

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

import projeto.integrador2.main.model.Answer;
import projeto.integrador2.main.service.AnswerService;

@RestController
@RequestMapping(path = "/api/answer")
public class AnswerController {

	@Autowired
	AnswerService service;

	@GetMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<Answer> find(@PathVariable("id") int id) {
		return new ResponseEntity<Answer>(service.find(id), HttpStatus.OK);
	}

	@PostMapping("/question/{id}")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public void save(@PathVariable("id") int question_id, @RequestBody Answer answer) {
		service.saveAnswerOnQuestion(question_id, answer);
	}

	@PutMapping(path = "{id}")
	//@PreAuthorize("hasAuthority('PROFESSOR')")
	public void update(@PathVariable("id") int id, @RequestBody Answer answer) {
		service.save(id, answer);
	}

	@DeleteMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
}
