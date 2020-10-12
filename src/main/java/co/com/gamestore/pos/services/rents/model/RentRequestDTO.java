package co.com.gamestore.pos.services.rents.model;

import java.util.Date;
import java.util.List;

import co.com.gamestore.framework.dto.BaseDTO;
import co.com.gamestore.pos.services.clients.model.ClientDTO;
import co.com.gamestore.pos.services.main.model.UserDTO;
import co.com.gamestore.pos.services.products.model.ProductDTO;

/**
 * 
 * @author Jonathan.Barrera
 * 
 *         DTO to save client information and pass the data through classes
 */
public class RentRequestDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long consecutive;
	private ClientDTO client;
	private UserDTO user;
	private Long totalValue;
	private Date rentalDate;
	private Date rentalDateFinish;
	private List<ProductDTO> products;
	/**
	 * 
	 */
	public RentRequestDTO() {
		super();
	}
	/**
	 * @param client
	 * @param user
	 * @param totalValue
	 * @param rentalDate
	 * @param rentalDateFinish
	 * @param products
	 */
	public RentRequestDTO(ClientDTO client, UserDTO user, Long totalValue, Date rentalDate, Date rentalDateFinish,
			List<ProductDTO> products) {
		super();
		this.client = client;
		this.user = user;
		this.totalValue = totalValue;
		this.rentalDate = rentalDate;
		this.rentalDateFinish = rentalDateFinish;
		this.products = products;
	}
	/**
	 * @return the client
	 */
	public ClientDTO getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	/**
	 * @return the totalValue
	 */
	public Long getTotalValue() {
		return totalValue;
	}
	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(Long totalValue) {
		this.totalValue = totalValue;
	}
	/**
	 * @return the rentalDate
	 */
	public Date getRentalDate() {
		return rentalDate;
	}
	/**
	 * @param rentalDate the rentalDate to set
	 */
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	/**
	 * @return the rentalDateFinish
	 */
	public Date getRentalDateFinish() {
		return rentalDateFinish;
	}
	/**
	 * @param rentalDateFinish the rentalDateFinish to set
	 */
	public void setRentalDateFinish(Date rentalDateFinish) {
		this.rentalDateFinish = rentalDateFinish;
	}
	/**
	 * @return the products
	 */
	public List<ProductDTO> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	/**
	 * @return the consecutive
	 */
	public Long getConsecutive() {
		return consecutive;
	}
	/**
	 * @param consecutive the consecutive to set
	 */
	public void setConsecutive(Long consecutive) {
		this.consecutive = consecutive;
	}
	@Override
	public String toString() {
		return "rentDTO [client=" + client + ", user=" + user + ", totalValue=" + totalValue + ", rentalDate="
				+ rentalDate + ", rentalDateFinish=" + rentalDateFinish + ", products=" + products + "]";
	}
	
	
	
}
