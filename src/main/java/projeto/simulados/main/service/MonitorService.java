package projeto.simulados.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.Monitor;
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
}
