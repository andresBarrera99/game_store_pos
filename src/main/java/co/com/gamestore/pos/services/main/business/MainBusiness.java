package co.com.gamestore.pos.services.main.business;

import java.util.Map;

import co.com.gamestore.framework.business.BaseBusiness;
import co.com.gamestore.framework.error.CustomErrorException;
import co.com.gamestore.framework.security.encrypt.aesb64.EncrypAESB64;
import co.com.gamestore.pos.services.main.model.UserDTO;
import co.com.gamestore.pos.services.main.repository.MainRepository;

public class MainBusiness extends BaseBusiness<MainRepository> {
	/**
	 * Method to Sign in
	 * @param loginRequest
	 * @return the userDTO
	 * @throws Exception
	 */
	public UserDTO attemptLogin(Map<String,Object> loginRequest) throws Exception {
		UserDTO user;
		try {
			String encryptedPass = EncrypAESB64.encryptAES((String)loginRequest.get("password"));
			loginRequest.put("password", encryptedPass);
			user = getRepository().attemptLogin(loginRequest);
			// the cursor does not return information
			if(null == user)
				throw new CustomErrorException("Usuario y/o contraseña incorrecta");
			//validate if the user is active
			if (!getRepository().validateUserStatus(user))
				throw new CustomErrorException("El usuario no se encuentra activo");
		} catch (Exception e) {
			return handleError(e,UserDTO.class);
		}
		user.setSuccess(true);
		return user;
	}

}
