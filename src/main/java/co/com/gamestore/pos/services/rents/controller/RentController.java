package co.com.gamestore.pos.services.rents.controller;

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
import co.com.gamestore.pos.services.rents.business.RentBusiness;
import co.com.gamestore.pos.services.rents.model.RentRequestDTO;
import co.com.gamestore.pos.services.rents.repository.RentRepository;


//Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/rents")
public class RentController extends BaseController<RentBusiness,RentRepository>{
		
	public RentController() throws CustomErrorException {
		super();
	}

	@PostMapping(path = "/create")
	public ResponseEntity<BaseDTO> createProduct(@RequestBody RentRequestDTO request) throws Exception{
		BaseDTO response = getBusiness().createRent(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	
}

