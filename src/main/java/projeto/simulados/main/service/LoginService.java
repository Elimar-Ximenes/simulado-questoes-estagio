package projeto.simulados.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import projeto.simulados.main.model.Login;
import projeto.simulados.main.repository.LoginRepository;


@Service
public class LoginService {

	@Autowired
	LoginRepository repository;

	public Login save(Login entity) {
		entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
		return repository.save(entity);
	}

	public void delete(int id) {
		Login login = findLogin(id);
		repository.delete(login);
	}

	public Login find(int id) {
		if (id < 1) {
			return null;
		}

		Optional<Login> login = repository.findById(id);
		if (login.isPresent()) {
			return login.get();
		}

		return null;
	}

	private Login findLogin(int id) {
		if (id < 1) {
			return null;
		}

		Optional<Login> login = repository.findById(id);

		if (login.isPresent()) {
			return login.get();
		}

		return null;
	}

	public void update(int id, Login login) {
		BCryptPasswordEncoder encryptPassword = new BCryptPasswordEncoder();
		Login searchLogin = find(id);
		if (login.getEmail() == searchLogin.getEmail()) {
			searchLogin.getEmail();
		} else {
			searchLogin.setEmail(login.getEmail());
		}
		String encryptedPassword = encryptPassword.encode(login.getPassword());
		searchLogin.setPassword(encryptedPassword);
		repository.save(searchLogin);
	}

	public Login findLoginByEmail(String email) { // TODO
		return repository.findByEmail(email);
	}

	public List<Login> findAll() {
		return repository.findAll();
	}
}
