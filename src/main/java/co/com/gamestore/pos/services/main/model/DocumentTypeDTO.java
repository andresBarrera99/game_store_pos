package co.com.gamestore.pos.services.main.model;

public class DocumentTypeDTO{
	
	/**
	 * 
	 */
	private Integer ID;
	private String description;
	private String initials;
	
	/**
	 * 
	 */
	public DocumentTypeDTO() {
		super();
	}

	/**
	 * @param iD
	 * @param description
	 * @param initials
	 */
	public DocumentTypeDTO(Integer iD, String description, String initials) {
		super();
		ID = iD;
		this.description = description;
		this.initials = initials;
	}

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
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
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * @param initials the initials to set
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}

	@Override
	public String toString() {
		return "DocumentTypeDTO [ID=" + ID + ", description=" + description + ", initials=" + initials + "]";
	}
	
}
