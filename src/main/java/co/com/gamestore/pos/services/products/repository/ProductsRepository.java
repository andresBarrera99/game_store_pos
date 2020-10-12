package co.com.gamestore.pos.services.products.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.com.gamestore.framework.dto.BaseDTO;
import co.com.gamestore.framework.error.CustomErrorException;
import co.com.gamestore.framework.repository.BaseRepository;
import co.com.gamestore.pos.services.main.model.BrandDTO;
import co.com.gamestore.pos.services.main.model.TechnologyDTO;
import co.com.gamestore.pos.services.products.model.ProductDTO;
import co.com.gamestore.pos.services.products.model.ProductTechnologyDTO;


public class ProductsRepository extends BaseRepository {

	/**
	 * Method to create a Product
	 * @param request
	 * @param c
	 * @return the Product request with the generated key
	 * @throws IOException
	 * @throws SQLException
	 * @throws CustomErrorException
	 */
	public ProductDTO createProduct(ProductDTO request, Connection c) throws IOException,SQLException, CustomErrorException  {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getInsert("INSERT_NEW_PRODUCT.sql"),Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, request.getName());
			pstmt.setString(2, request.getDescription());
			pstmt.setString(3, getDateFormated(request.getAnio()));
			pstmt.setInt(4, request.getBrand().getId());
			pstmt.setLong(5, request.getPrice());
			int rowCount = pstmt.executeUpdate();
			if (rowCount > 0) {
				rs = pstmt.getGeneratedKeys();
				while(rs.next()) {
					request.setId(rs.getLong(1));
				}
				return request;
			}else {
				throw new CustomErrorException("No se logró registrar el Producto con exito, por favor intente de nuevo");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, null);
		}
	}

	public BaseDTO searchProduct(ProductDTO request)  throws Exception {
		BaseDTO response = new BaseDTO();
		Connection c = connect(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		try {
			pstmt = c.prepareStatement(getQuery("QUERY_GET_PRODUCTS.sql"));
			pstmt.setString(1, getLikeParameter(request.getName()));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setId(rs.getLong("product_id"));
				product.setName(rs.getString("product_name"));
				product.setDescription(rs.getString("product_description"));
				product.setAnio(getDateFormatedFromString(rs.getString("anio")));
				product.setPrice(rs.getLong("product_value"));
				product.setQuantity(rs.getLong("quantity"));
				product.setBrand(new BrandDTO(rs.getInt("brand_id"),rs.getString("brand_name")));
				product.setTechnology(new TechnologyDTO(rs.getInt("tech_id"),rs.getString("tech_name")));
				list.add(product);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, c);
		}
		response.setList(list);
		return response;
	}

	public void updateProduct(ProductDTO request) throws CustomErrorException, SQLException, IOException {
		Connection c = connect(false);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getUpdate("UPDATE_PRODUCT.sql"));
			pstmt.setString(1, request.getName());
			pstmt.setString(2, request.getDescription());
			pstmt.setString(3, getDateFormated(request.getAnio()));
			pstmt.setLong(4, request.getPrice());
			pstmt.setLong(5, request.getId());
			int rowCount = pstmt.executeUpdate();
			if (rowCount < 1) {
				throw new CustomErrorException("No se logró actualizar el Producto con exito, por favor intente de nuevo");
			}
			updateStock(request,c);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, c);
		}
	}
	
	public void updateStock(ProductDTO request,Connection c) throws CustomErrorException, SQLException, IOException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(getUpdate("UPDATE_PRODUCT_STOCK.sql"));
			pstmt.setLong(1, request.getQuantity());
			pstmt.setLong(2, request.getId());
			pstmt.setLong(3, request.getTechnology().getId());
			int rowCount = pstmt.executeUpdate();
			if (rowCount < 1) {
				throw new CustomErrorException("No se logró actualizar el Producto con exito, por favor intente de nuevo");
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, null);
		}
	}

	public void insertProdTech(ProductDTO request, Connection c) throws SQLException, CustomErrorException, IOException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			for (ProductTechnologyDTO tech : request.getTechnologies()) {
				pstmt = c.prepareStatement(getInsert("INSERT_PROD_TECH.sql"));
				pstmt.setLong(1, request.getId());
				pstmt.setLong(2, tech.getTechnology().getId());
				pstmt.setLong(3, tech.getQuantity());
				int rowCount = pstmt.executeUpdate();
				if (rowCount < 1) {
					throw new CustomErrorException("No se logró asociar el producto a la tecnología con exito, por favor intente de nuevo");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeAll(rs, pstmt, c);
		}
	}

	

}
