package projeto.simulados.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projeto.simulados.main.dto.MonitorDetailsDTO;
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
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    //@PreAuthorize("hasAnyAuthority('ALUNO','ADMIN')")
    public ResponseEntity<Monitor> find(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.find(id), HttpStatus.OK);
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

    // New Routes --- Elimar
    @PostMapping("/student/{studentId}/teacher/{teacherId}")
    //@PreAuthorize("hasAnyAuthority('ALUNO')")
    public void save(@PathVariable("studentId") int studentId, @PathVariable("teacherId") int teacherId, @RequestBody Monitor monitor) {
        service.saveMonitorOnTeacher(studentId, teacherId, monitor);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Monitor>> getMonitorsByStudentId(@PathVariable("studentId") int studentId) {
        return new ResponseEntity<>(service.getMonitorsByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Monitor>> getMonitorsByTeacherId(@PathVariable("teacherId") int teacherId) {
        return new ResponseEntity<>(service.getMonitorsByTeacherId(teacherId), HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}/teacher/{teacherId}")
    public ResponseEntity<List<Monitor>> getMonitorsByStudentAndTeacherId(@PathVariable("studentId") int studentId, @PathVariable("teacherId") int teacherId) {
        return new ResponseEntity<>(service.getMonitorsByStudentAndTeacherId(studentId, teacherId), HttpStatus.OK);
    }

	// Teste consulta com detalhes
	@GetMapping("/student/{studentId}/details")
	public ResponseEntity<List<MonitorDetailsDTO>> getMonitorsByStudentIdWithDetails(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<>(service.getMonitorsByStudentIdWithDetails(studentId), HttpStatus.OK);
	}

	@GetMapping("/teacher/{teacherId}/details")
	public ResponseEntity<List<MonitorDetailsDTO>> getMonitorsByTeacherIdWithDetails(@PathVariable("teacherId") int teacherId) {
		return new ResponseEntity<>(service.getMonitorsByTeacherIdWithDetails(teacherId), HttpStatus.OK);
	}

	@GetMapping("/student/{studentId}/teacher/{teacherId}/details")
	public ResponseEntity<List<MonitorDetailsDTO>> getMonitorsByStudentAndTeacherIdWithDetails(@PathVariable("studentId") int studentId, @PathVariable("teacherId") int teacherId) {
		return new ResponseEntity<>(service.getMonitorsByStudentAndTeacherIdWithDetails(studentId, teacherId), HttpStatus.OK);
	}

}
