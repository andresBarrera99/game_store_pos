package co.com.gamestore.pos.services.rents.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.com.gamestore.framework.error.CustomErrorException;
import co.com.gamestore.framework.repository.BaseRepository;
import co.com.gamestore.pos.services.products.model.ProductDTO;
import co.com.gamestore.pos.services.rents.model.RentRequestDTO;


public class RentRepository extends BaseRepository {

	/**
	 * Method to create a rent
	 * @param request
	 * @param c
	 * @return the Product request with the generated key
	 * @throws IOException
	 * @throws SQLException
	 * @throws CustomErrorException
	 */
	public boolean createRent(RentRequestDTO request, Connection c) throws IOException,SQLException, CustomErrorException  {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getInsert("INSERT_NEW_RENT_HEADER.sql"),Statement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, request.getUser().getUserID());
			pstmt.setLong(2, request.getClient().getClientID());
			pstmt.setLong(3, request.getTotalValue());
			pstmt.setString(4, getDateFormated(request.getRentalDate()));
			pstmt.setString(5, getDateFormated(request.getRentalDateFinish()));
			int rowCount = pstmt.executeUpdate();
			if (rowCount > 0) {
				rs = pstmt.getGeneratedKeys();
				while(rs.next()) {
					request.setConsecutive(rs.getLong(1));
				}
				return true;
			}else {
				throw new CustomErrorException("No se logró registrar la venta con éxito, por favor intente de nuevo");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, null);
		}
	}

	/**
	 * Method to insert the rent detail
	 * @param request
	 * @param c
	 * @return the Product request with the generated key
	 * @throws IOException
	 * @throws SQLException
	 * @throws CustomErrorException
	 */
	public void insertRentDetail(RentRequestDTO request, Connection c) throws IOException,SQLException, CustomErrorException  {
		PreparedStatement pstmt = null;
		try {
			for (ProductDTO product : request.getProducts()) {
				validateStock(product, c);
				pstmt = c.prepareStatement(getInsert("INSERT_NEW_RENT_DETAIL.sql"),Statement.RETURN_GENERATED_KEYS);
				pstmt.setLong(1, request.getConsecutive());
				pstmt.setLong(2, product.getId());
				pstmt.setLong(3, product.getPrice());
				pstmt.setBoolean(4, false);
				int rowCount = pstmt.executeUpdate();
				if (rowCount <1) {
					throw new CustomErrorException(String.format("No se logró registrar el detalle de la venta para el producto %s con éxito, por favor intente de nuevo",product.getName()));
				}
				reduceProductStock(product,c);
			}			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(null, pstmt, c);
		}
	}

	private void reduceProductStock(ProductDTO product, Connection c) throws IOException,SQLException, CustomErrorException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getUpdate("UPDATE_PRODUCT_STOCK.sql"));
			pstmt.setLong(1, product.getQuantity()-1);
			pstmt.setLong(2, product.getId());
			pstmt.setLong(3, product.getTechnology().getId());
			int rowCount = pstmt.executeUpdate();
			if (rowCount < 1) {
				throw new CustomErrorException("No se logró actualizar el stock del Producto con exito, por favor intente de nuevo");
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, null);
		}
	}

	public void validateStock(ProductDTO product, Connection c) throws IOException,SQLException, CustomErrorException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getQuery("QUERY_VALIDATE_STOCK_PROD.sql"));
			pstmt.setLong(1, product.getId());
			pstmt.setLong(2, product.getTechnology().getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getLong("quantity") < 1) {
					throw new CustomErrorException(String.format("No hay stock disponible para el producto: %s y la tecnología %s",product.getName(),product.getTechnology().getName()));
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, null);
		}
		
	}
}
