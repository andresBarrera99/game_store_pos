package co.com.gamestore.pos.services.main.model;

public class TechnologyDTO{
	
	/**
	 * 
	 */
	private Integer id;
	private String name;
	
	/**
	 * Basic constructor
	 */
	public TechnologyDTO() {
		super();
	}
	
	
	/**
	 * Basic constructor with parameters
	 * @param id
	 * @param name
	 */
	public TechnologyDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "TechnologyDTO [id=" + id + ", name=" + name + "]";
	}
	
	
}
