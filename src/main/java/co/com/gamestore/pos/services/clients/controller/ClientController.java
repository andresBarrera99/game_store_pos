package co.com.gamestore.pos.services.clients.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.gamestore.framework.controller.BaseController;
import co.com.gamestore.framework.dto.BaseDTO;
import co.com.gamestore.framework.error.CustomErrorException;
import co.com.gamestore.pos.services.clients.business.ClientBusiness;
import co.com.gamestore.pos.services.clients.model.ClientDTO;
import co.com.gamestore.pos.services.clients.repository.ClientRepository;


//Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/clients")
public class ClientController extends BaseController<ClientBusiness,ClientRepository>{
		
	public ClientController() throws CustomErrorException {
		super();
	}

	@PostMapping(path = "/create")
	public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO request) throws Exception{
		ClientDTO response = getBusiness().createClient(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path = "/search")
	public ResponseEntity<ClientDTO> searchClient(@Valid @RequestBody ClientDTO request) throws Exception{
		ClientDTO response = getBusiness().searchClient(request);
		return new ResponseEntity<>(response,HttpStatus.OK);		
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<BaseDTO> updateClient(@RequestBody ClientDTO request) throws Exception{
		BaseDTO response = getBusiness().updateClient(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}

