package co.com.gamestore.pos.services.products.model;

import co.com.gamestore.pos.services.main.model.TechnologyDTO;

public class ProductTechnologyDTO {
	

	private TechnologyDTO technology;
	private Long quantity;
	
	
	
	/**
	 * @param technology
	 */
	public ProductTechnologyDTO(TechnologyDTO technology) {
		super();
		this.technology = technology;
	}
	/**
	 * @param technology
	 * @param quantity
	 */
	public ProductTechnologyDTO(TechnologyDTO technology, Long quantity) {
		super();
		this.technology = technology;
		this.quantity = quantity;
	}
	/**
	 * @return the technology
	 */
	public TechnologyDTO getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(TechnologyDTO technology) {
		this.technology = technology;
	}
	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductTechnologyDTO [technology=" + technology + ", quantity=" + quantity + "]";
	}
	
	

}
