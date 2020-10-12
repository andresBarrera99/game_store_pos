package co.com.gamestore.pos.services.products.controller;

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
import co.com.gamestore.pos.services.products.business.ProductsBusiness;
import co.com.gamestore.pos.services.products.model.ProductDTO;
import co.com.gamestore.pos.services.products.repository.ProductsRepository;


//Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/products")
public class ProductsController extends BaseController<ProductsBusiness,ProductsRepository>{
		
	public ProductsController() throws CustomErrorException {
		super();
	}

	@PostMapping(path = "/create")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO request) throws Exception{
		ProductDTO response = getBusiness().createProduct(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path = "/search")
	public ResponseEntity<BaseDTO> searchProduct(@RequestBody ProductDTO request) throws Exception{
		BaseDTO response = getBusiness().searchProduct(request);
		return new ResponseEntity<>(response,HttpStatus.OK);		
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<BaseDTO> updateProduct(@RequestBody ProductDTO request) throws Exception{
		BaseDTO response = getBusiness().updateProduct(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}

