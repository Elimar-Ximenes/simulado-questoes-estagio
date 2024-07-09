package projeto.simulados.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.simulados.main.dto.MonitorDetailsDTO;
import projeto.simulados.main.model.Monitor;
import projeto.simulados.main.model.Teacher;
import projeto.simulados.main.model.Student;
import projeto.simulados.main.repository.MonitorRepository;
import projeto.simulados.main.repository.StudentRepository;
import projeto.simulados.main.repository.TeacherRepository;

@Service
public class MonitorService {

    @Autowired
    private MonitorRepository monitorRepository;

    @Autowired
	StudentRepository studentRepository;

    @Autowired
	TeacherRepository tearcherRepository;

    public void save(int id, Monitor entity) {
        if (id != 0) {
            // Se for uma atualização, seta o ID na entidade
            entity.setId(id);
        }
        monitorRepository.save(entity);
    }

    public void delete(int id) {
        Monitor monitor = find(id);
        if (monitor != null) {
            monitorRepository.delete(monitor);
        }
    }

    public Monitor find(int id) {
        if (id < 1) {
            return null;
        }

        Optional<Monitor> optionalMonitor = monitorRepository.findById(id);

        if (optionalMonitor.isPresent()) {
            return optionalMonitor.get();
        }

        return null;
    }

    public List<Monitor> findAll() {
		return monitorRepository.findAll();
	}
    
    //--------------------

    public List<Monitor> getMonitorsByStudentId(int studentId) {
        return monitorRepository.findByStudentId(studentId);
    }

    public List<Monitor> getMonitorsByTeacherId(int teacherId) {
        return monitorRepository.findByTeacherId(teacherId);
    }

    public List<Monitor> getMonitorsByStudentAndTeacherId(int studentId, int teacherId) {
        return monitorRepository.findByStudentIdAndTeacherId(studentId, teacherId);
    }

	public void saveMonitorOnTeacher( int student_id, int teacher_id, Monitor monitor) {

        Teacher teacher = tearcherRepository.findById(teacher_id).get();
        Student student = studentRepository.findById(student_id).get();

        monitor.setTeacher(teacher);
        monitor.setStudent(student);

        monitorRepository.save(monitor);
    }    

    //--------------teste---------------------


    public List<MonitorDetailsDTO> getMonitorsByStudentIdWithDetails(int studentId) {
        return monitorRepository.findByStudentIdWithDetails(studentId);
    }

    public List<MonitorDetailsDTO> getMonitorsByTeacherIdWithDetails(int teacherId) {
        return monitorRepository.findByTeacherIdWithDetails(teacherId);
    }

    public List<MonitorDetailsDTO> getMonitorsByStudentAndTeacherIdWithDetails(int studentId, int teacherId) {
        return monitorRepository.findByStudentAndTeacherIdWithDetails(studentId, teacherId);
    }


}
