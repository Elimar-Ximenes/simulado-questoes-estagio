package projeto.simulados.main.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projeto.simulados.main.model.MultipleChoiceQuestion;
import projeto.simulados.main.service.MultipleChoiceQuestionService;

@RestController
@RequestMapping(path = "/api/multiplechoicequestions")
public class MultipleChoiceQuestionController {

	@Autowired
	MultipleChoiceQuestionService service;

	@GetMapping(path = "/simulate")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<List<String>> findQuestionsFromSimulate() {
		return new ResponseEntity<List<String>>(service.printSimulate(), HttpStatus.OK);
	}

	@GetMapping
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<List<MultipleChoiceQuestion>> findAll() {
		return new ResponseEntity<List<MultipleChoiceQuestion>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<MultipleChoiceQuestion> find(@PathVariable("id") int id) {
		return new ResponseEntity<MultipleChoiceQuestion>(service.find(id), HttpStatus.OK);
	}

	@GetMapping(path = "/searchQuestionByTopic")
	//@PreAuthorize("hasAnyAuthority('PROFESSOR','ADMIN')")
	public ResponseEntity<List<MultipleChoiceQuestion>> find(@RequestParam("name") String name) {
		return new ResponseEntity<List<MultipleChoiceQuestion>>(service.findMultipleChoiceQuestionsByTopic(name), HttpStatus.OK);
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

	//incluido variavel qType que corresponde ao metodo no QuestionService
	@PostMapping("/topics/{id}")
	//@PreAuthorize("hasAuthority('PROFESSOR')")
	public void save(@PathVariable("id") int topic_id,  @RequestParam int qType, @RequestBody MultipleChoiceQuestion multipleChoiceQuestion) {
		service.saveQuestionOnTopic(topic_id, qType, multipleChoiceQuestion); 
	}

	@PutMapping(path = "{id}")
	//@PreAuthorize("hasAuthority('PROFESSOR')")
	public void update(@PathVariable("id") int id, @RequestBody MultipleChoiceQuestion multipleChoiceQuestion) {
		service.save(id, multipleChoiceQuestion);
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

