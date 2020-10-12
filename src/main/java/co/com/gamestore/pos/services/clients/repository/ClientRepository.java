package co.com.gamestore.pos.services.clients.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.com.gamestore.framework.error.CustomErrorException;
import co.com.gamestore.framework.repository.BaseRepository;
import co.com.gamestore.framework.util.Utils;
import co.com.gamestore.pos.services.clients.model.ClientDTO;


public class ClientRepository extends BaseRepository {

	/**
	 * Method to create a client
	 * @param request
	 * @param c
	 * @return the client request with the generated key
	 * @throws IOException
	 * @throws SQLException
	 * @throws CustomErrorException
	 */
	public ClientDTO createClient(ClientDTO request, Connection c) throws IOException,SQLException, CustomErrorException  {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getInsert("INSERT_NEW_CLIENT.sql"),Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, request.getName());
			pstmt.setString(2, request.getLastName1());
			pstmt.setString(3, request.getLastName2());
			pstmt.setInt(4, request.getDocType().getID());
			pstmt.setString(5, request.getDocNumber());
			pstmt.setString(6, request.getAddress());
			pstmt.setInt(7, request.getAge());
			pstmt.setLong(8, Utils.isNull(request.getPhone()) ? 0L : request.getPhone());
			pstmt.setLong(9, request.getCellPhone());
			int rowCount = pstmt.executeUpdate();
			if (rowCount > 0) {
				rs = pstmt.getGeneratedKeys();
				while(rs.next()) {
					request.setClientID(rs.getLong(1));
				}
				return request;
			}else {
				throw new CustomErrorException("No se logró registrar el cliente con exito, por favor intente de nuevo");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, null);
		}
	}

	public boolean validateClientRegister(ClientDTO request, Connection c) throws IOException,SQLException, CustomErrorException   {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getQuery("QUERY_VALIDATE_CLIENT_REGISTER.sql"));
			pstmt.setInt(1, request.getDocType().getID());
			pstmt.setString(2, request.getDocNumber());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) == 0) {
					return false;
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		return true;
		
	}

	public ClientDTO searchClient(ClientDTO request)  throws Exception {
		Connection c = connect(true);
		ClientDTO response = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getQuery("QUERY_GET_CLIENT.sql"));
			pstmt.setInt(1, request.getDocType().getID());
			pstmt.setString(2, request.getDocNumber());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				response = new ClientDTO();
				response.setClientID(rs.getLong("customer_id"));
				response.setName(rs.getString("customer_names"));
				response.setLastName1(rs.getString("last_name1"));
				response.setLastName2(rs.getString("last_name2"));
				response.setAddress(rs.getString("address"));
				response.setAge(rs.getInt("age"));
				response.setPhone(rs.getLong("phone"));
				response.setCellPhone(rs.getLong("cellphone"));
				response.setDocType(request.getDocType());
				response.setDocNumber(request.getDocNumber());
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, c);
		}
		return response;
	}

	public void updateClient(ClientDTO request) throws CustomErrorException, SQLException, IOException {
		Connection c = connect(false);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getUpdate("UPDATE_CLIENT.sql"));
			pstmt.setString(1, request.getName());
			pstmt.setString(2, request.getLastName1());
			pstmt.setString(3, request.getLastName2());
			pstmt.setString(4, request.getAddress());
			pstmt.setInt(5, request.getAge());
			pstmt.setLong(6, Utils.isNull(request.getPhone()) ? 0L : request.getPhone());
			pstmt.setLong(7, request.getCellPhone());
			pstmt.setInt(8, request.getDocType().getID());
			pstmt.setString(9, request.getDocNumber());
			int rowCount = pstmt.executeUpdate();
			if (rowCount < 1) {
				throw new CustomErrorException("No se logró actualizar el cliente con exito, por favor intente de nuevo");
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, c);
		}
	}

	

}
