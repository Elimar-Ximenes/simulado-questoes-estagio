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

import projeto.integrador2.main.model.Teacher;
import projeto.integrador2.main.service.TeacherService;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController {

	@Autowired
	TeacherService service;

	@GetMapping
	//@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<Teacher>> findAll() {
		return new ResponseEntity<List<Teacher>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<Teacher> find(@PathVariable("id") int id) {
		return new ResponseEntity<Teacher>(service.find(id), HttpStatus.OK);
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

	@PostMapping
	//@PreAuthorize("hasAuthority('PROFESSOR')")
	public void save(@RequestBody Teacher teacher) {
		service.save(0, teacher);
	}

	@PutMapping(path = "{id}")
	//@PreAuthorize("hasAuthority('PROFESSOR')")
	public void update(@PathVariable("id") int id, @RequestBody Teacher teacher) {
		service.save(id, teacher);
	}

	@DeleteMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

	@GetMapping(path = "/recoveryCredentials")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR')")
	public ResponseEntity<Teacher> findEntity(@RequestParam("email") String email) {
		return new ResponseEntity<Teacher>(service.recoveryCredentials(email), HttpStatus.OK);
	}

	@PutMapping(path = "/recoveryCredentials/{answerSecretAsk}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR')")
	public void update(@PathVariable("answerSecretAsk") String answerSecretAsk, @RequestBody Teacher teacher) {
		String secretAnswer = (String) service.findAnswerBySecretAnswer(answerSecretAsk);
		if (answerSecretAsk.equals(secretAnswer)) {
			int id = service.findIdBySecretAnswer(answerSecretAsk);
			service.save(id, teacher);
		}
	}

}