package co.com.gamestore.pos.services.products.business;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import co.com.gamestore.framework.business.BaseBusiness;
import co.com.gamestore.framework.dto.BaseDTO;
import co.com.gamestore.framework.error.CustomErrorException;
import co.com.gamestore.framework.repository.BaseRepository;
import co.com.gamestore.framework.util.Utils;
import co.com.gamestore.pos.services.products.model.ProductDTO;
import co.com.gamestore.pos.services.products.repository.ProductsRepository;

@Service
public class ProductsBusiness extends BaseBusiness<ProductsRepository> {
	
	public ProductDTO createProduct(ProductDTO request) throws ReflectiveOperationException {
		ProductDTO newProduct = null;
		Connection c = null;
		try {
			c = BaseRepository.connect(false);
			newProduct = getRepository().createProduct(request,c);
			getRepository().insertProdTech(request,c);
		}catch (Exception e) {
			e.printStackTrace();
			return handleError(e,ProductDTO.class);
		}	
		newProduct.setSuccess(true);
		return newProduct;
	}

	public BaseDTO searchProduct(ProductDTO request) throws ReflectiveOperationException {
		BaseDTO response = null;
		try {
			response = getRepository().searchProduct(request);
			if (Utils.isNull(response) || Utils.isNull(response.getList()) || response.getList().size() == 0) {
				throw new CustomErrorException("No se han encontrado productos con los criterios de busqueda suministrados");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return handleError(e,ProductDTO.class);
		}
		response.setSuccess(true);
		return response;
	}

	public BaseDTO updateProduct(ProductDTO request) throws ReflectiveOperationException {
		BaseDTO response = new BaseDTO();
		try {
			getRepository().updateProduct(request);
		} catch (Exception e) {
			e.printStackTrace();
			return handleError(e, BaseDTO.class);
		}
		response.setSuccess(true);
		return response;
	}
}
