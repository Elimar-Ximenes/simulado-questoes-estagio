package projeto.simulados.main.controller;

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

import projeto.simulados.main.model.Student;
import projeto.simulados.main.service.StudentService;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping
	//@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<Student>> findAll() {
		return new ResponseEntity<List<Student>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('ALUNO','ADMIN')")
	public ResponseEntity<Student> find(@PathVariable("id") int id) {
		return new ResponseEntity<Student>(service.find(id), HttpStatus.OK);
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
	//@PreAuthorize("hasAuthority('ALUNO')")
	public void save(@RequestBody Student student) {
		service.save(0, student);
	}

	@PutMapping(path = "{id}")
	//@PreAuthorize("hasAuthority('ALUNO')")
	public void update(@PathVariable("id") int id, @RequestBody Student student) {
		service.save(id, student);
	}

	@DeleteMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('ALUNO','ADMIN')")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

	@GetMapping(path = "/recoveryCredentials")
	//@PreAuthorize("hasAuthority('ALUNO')")
	public ResponseEntity<Student> findEntity(@RequestParam("email") String email) {
		return new ResponseEntity<Student>(service.recoveryCredentials(email), HttpStatus.OK);
	}

	@PutMapping(path = "/recoveryCredentials/{answerSecretAsk}")
	//@PreAuthorize("hasAuthority('ALUNO')")
	public void update(@PathVariable("answerSecretAsk") String answerSecretAsk, @RequestBody Student student) {
		String secretAnswer = (String) service.findAnswerBySecretAnswer(answerSecretAsk);
		if (answerSecretAsk.equals(secretAnswer)) {
			int id = service.findIdBySecretAnswer(answerSecretAsk);
			service.save(id, student);
		}
	}

	@PutMapping(path = "{id1}/denounce/{id2}")
	//@PreAuthorize("hasAuthority('ALUNO')")
	public void update(@PathVariable("id1") int question_id, @PathVariable("id2") int student_id) {
		service.includeQuestionDenouncedList(question_id, student_id);
	}

}
