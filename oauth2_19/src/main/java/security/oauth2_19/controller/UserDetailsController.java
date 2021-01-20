package security.oauth2_19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import security.oauth2_19.entity.Client;
import security.oauth2_19.repository.ClientRepository;

@RestController
public class UserDetailsController {

	@Autowired
	private ClientRepository clientRepository;

	@PostMapping("/saveIt")
	public ResponseEntity<?> saveClientDetailsInDB(@RequestBody Client client) {
		Client clientFromDB = clientRepository.save(client);
		return ResponseEntity.status(HttpStatus.OK).body(new ModelMap().addAttribute("response", clientFromDB));
	}

	@GetMapping("/getIt")
	public ResponseEntity<?> getClientsDetails() {

		return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
	}
}
