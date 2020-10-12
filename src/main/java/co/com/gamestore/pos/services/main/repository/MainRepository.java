package co.com.gamestore.pos.services.main.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.com.gamestore.framework.dto.BaseDTO;
import co.com.gamestore.framework.repository.BaseRepository;
import co.com.gamestore.pos.services.main.model.BrandDTO;
import co.com.gamestore.pos.services.main.model.DocumentTypeDTO;
import co.com.gamestore.pos.services.main.model.TechnologyDTO;
import co.com.gamestore.pos.services.main.model.UserDTO;

public class MainRepository extends BaseRepository {
	/**
	 * Method to Sign in
	 * @param loginRequest
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public UserDTO attemptLogin(Map<String, Object> loginRequest) throws IOException,SQLException  {
		UserDTO user = null;
		Connection c = connect(true);
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {

			ps = c.prepareStatement(getQuery("QUERY_ATTEMPT_LOGIN.sql"));
			ps.setString(1, (String) loginRequest.get("username"));
			ps.setString(2, (String) loginRequest.get("password"));
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new UserDTO(rs.getLong("user_id"), rs.getString("user_names"), rs.getString("last_name1"), rs.getString("last_name2"),
						rs.getString("doc_number"), rs.getInt("doc_type_id"));
			}
		} catch (IOException | SQLException | ClassCastException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, ps, c);
		}
		
		return user;
	}
	
	/**
	 * Method to be safe the user is active
	 * @param user
	 * @return true if the user is active, false in any other case
	 * @throws SQLException
	 * @throws IOException
	 */
	public Boolean validateUserStatus(UserDTO user) throws SQLException, IOException {
		Connection c = connect(true);
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(getQuery("QUERY_VALIDATE_USER_STATUS.sql"));
			ps.setLong(1, user.getUserID());
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) == 0) {
					return false;
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, ps, c);
		}
		return true;
	}

	public BaseDTO getDocumenTypes() throws Exception {
		BaseDTO response = new BaseDTO();
		List<DocumentTypeDTO> list = new ArrayList<>();
		Connection c = connect(true);
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(getQuery("QUERY_GET_DOCUMENT_TYPES.sql"));
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DocumentTypeDTO(rs.getInt("doc_type_id"),rs.getString("doc_description"),rs.getString("doc_initials")));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, ps, c);
		}
		response.setList(list);
		return response;
	}
	
	/**
	 * Method to get brands
	 * @return
	 * @throws Exception
	 */
	public BaseDTO getBrands() throws Exception {
		BaseDTO response = new BaseDTO();
		List<BrandDTO> list = new ArrayList<>();
		Connection c = connect(true);
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(getQuery("QUERY_GET_BRANDS.sql"));
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BrandDTO(rs.getInt("brand_id"),rs.getString("brand_name")));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, ps, c);
		}
		response.setList(list);
		return response;
	}
	
	/**
	 * Method to get technologies
	 * @return
	 * @throws Exception
	 */
	public BaseDTO getTechnologies() throws Exception {
		BaseDTO response = new BaseDTO();
		List<TechnologyDTO> list = new ArrayList<>();
		Connection c = connect(true);
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(getQuery("QUERY_GET_TECHNOLOGIES.sql"));
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new TechnologyDTO(rs.getInt("tech_id"),rs.getString("tech_name")));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, ps, c);
		}
		response.setList(list);
		return response;
	}
	
}
