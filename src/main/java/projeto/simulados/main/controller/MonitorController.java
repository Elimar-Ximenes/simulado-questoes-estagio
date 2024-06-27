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
import org.springframework.web.bind.annotation.RestController;

import projeto.simulados.main.model.Monitor;
import projeto.simulados.main.service.MonitorService;

@RestController
@RequestMapping(path = "/api/monitor")
public class MonitorController {
    @Autowired
	MonitorService service;

    @GetMapping
	//@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<Monitor>> findAll() {
		return new ResponseEntity<List<Monitor>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('ALUNO','ADMIN')")
	public ResponseEntity<Monitor> find(@PathVariable("id") int id) {
		return new ResponseEntity<Monitor>(service.find(id), HttpStatus.OK);
	}

    @PostMapping
	//@PreAuthorize("hasAuthority('ALUNO')")
	public void save(@RequestBody Monitor monitor) {
		service.save(0, monitor);
	}

    @PutMapping(path = "{id}")
	//@PreAuthorize("hasAuthority('ALUNO')")
	public void update(@PathVariable("id") int id, @RequestBody Monitor monitor) {
		service.save(id, monitor);
	}

    @DeleteMapping(path = "{id}")
	//@PreAuthorize("hasAnyAuthority('ALUNO','ADMIN')")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

}
