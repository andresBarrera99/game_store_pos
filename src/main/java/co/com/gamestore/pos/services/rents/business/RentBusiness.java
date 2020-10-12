package co.com.gamestore.pos.services.rents.business;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import co.com.gamestore.framework.business.BaseBusiness;
import co.com.gamestore.framework.dto.BaseDTO;
import co.com.gamestore.framework.error.CustomErrorException;
import co.com.gamestore.framework.repository.BaseRepository;
import co.com.gamestore.pos.services.rents.model.RentRequestDTO;
import co.com.gamestore.pos.services.rents.repository.RentRepository;

@Service
public class RentBusiness extends BaseBusiness<RentRepository> {
	
	public BaseDTO createRent(RentRequestDTO request) throws ReflectiveOperationException {
		BaseDTO response = new BaseDTO();
		Connection c = null;
		try {
			c = BaseRepository.connect(false);
			if (!getRepository().createRent(request,c)) {
				throw new CustomErrorException("No se logró incentar el encabezado de la venta de manera exitosa");
			}
			getRepository().insertRentDetail(request, c);
		}catch (Exception e) {
			e.printStackTrace();
			return handleError(e,BaseDTO.class);
		}	
		response.setSuccess(true);
		return response;
	}

}
