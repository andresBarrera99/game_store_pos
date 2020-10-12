package co.com.gamestore.pos.services.products.model;

import java.util.Date;
import java.util.List;

import co.com.gamestore.framework.dto.BaseDTO;
import co.com.gamestore.pos.services.main.model.BrandDTO;
import co.com.gamestore.pos.services.main.model.TechnologyDTO;

/**
 * 
 * @author Jonathan.Barrera
 * 
 *         DTO to save client information and pass the data through classes
 */
public class ProductDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Date anio;
	private String description;
	private BrandDTO brand;
	private Long price;
	private TechnologyDTO technology;
	private List<ProductTechnologyDTO> technologies;
	private Long quantity;

	/**
	 * Basic constructor
	 * 
	 * @author Jonathan.Barrera
	 */
	public ProductDTO() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param anio
	 * @param description
	 * @param brand
	 * @param price
	 */
	public ProductDTO(Long id, String name, Date anio, String description, BrandDTO brand, Long price) {
		super();
		this.id = id;
		this.name = name;
		this.anio = anio;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the anio
	 */
	public Date getAnio() {
		return anio;
	}


	/**
	 * @param anio the anio to set
	 */
	public void setAnio(Date anio) {
		this.anio = anio;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the brand
	 */
	public BrandDTO getBrand() {
		return brand;
	}


	/**
	 * @param brand the brand to set
	 */
	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}


	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
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
	 * @return the technologies
	 */
	public List<ProductTechnologyDTO> getTechnologies() {
		return technologies;
	}

	/**
	 * @param technologies the technologies to set
	 */
	public void setTechnologies(List<ProductTechnologyDTO> technologies) {
		this.technologies = technologies;
	}
	/**
	 * @param technology the technologies to add
	 */
	public void addTechnology(ProductTechnologyDTO technology) {
		this.technologies.add(technology);
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
		return "ProductDTO [id=" + id + ", name=" + name + ", anio=" + anio + ", description=" + description
				+ ", brand=" + brand + ", price=" + price + ", technology=" + technology + ", technologies="
				+ technologies + ", quantity=" + quantity + "]";
	}
	
	

}
