package co.com.gamestore.pos.services.clients.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import co.com.gamestore.framework.business.BaseBusiness;
import co.com.gamestore.framework.error.CustomErrorException;
import co.com.gamestore.framework.repository.BaseRepository;
import co.com.gamestore.framework.response.BaseResponse;
import co.com.gamestore.framework.util.Utils;
import co.com.gamestore.pos.services.clients.model.ClientDTO;
import co.com.gamestore.pos.services.clients.repository.ClientRepository;

@Service
public class ClientBusiness extends BaseBusiness<ClientRepository> {
	
	public ClientDTO createClient(ClientDTO request) throws CustomErrorException, IOException, SQLException, ReflectiveOperationException {
		ClientDTO newClient = null;
		Connection c = null;
		try {
			c = BaseRepository.connect(false);
			if(getRepository().validateClientRegister(request,c))
				throw new CustomErrorException("Ya existe un cliente registrado con los datos suministrados ");
			 newClient = getRepository().createClient(request,c);
		}catch (Exception e) {
			return handleError(e,ClientDTO.class);
		}		
		finally {
			getRepository().closeC(c);
		}
		newClient.setSuccess(true);
		return newClient;
	}

	public ClientDTO searchClient(ClientDTO request) throws CustomErrorException, IOException, SQLException, ReflectiveOperationException {
		ClientDTO response = null;
		try {
			response = getRepository().searchClient(request);
			if (Utils.isNull(response)) {
				throw new CustomErrorException("No se han encontrado clientes con los criterios de busqueda suministrados");
			}
		} catch (Exception e) {
			return handleError(e,ClientDTO.class);
		}
		response.setSuccess(true);
		return response;
	}

	public BaseResponse updateClient(ClientDTO request) throws CustomErrorException, IOException, SQLException, ReflectiveOperationException {
		BaseResponse response = new BaseResponse();
		try {
			getRepository().updateClient(request);
		} catch (Exception e) {
			return handleError(e, BaseResponse.class);
		}
		response.setSuccess(true);
		return response;
	}
}
