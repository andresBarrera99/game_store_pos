package co.com.gamestore.pos.services.clients.model;

import co.com.gamestore.framework.dto.BaseDTO;
import co.com.gamestore.pos.services.main.model.DocumentTypeDTO;

/**
 * 
 * @author Jonathan.Barrera
 * 
 *         DTO to save client information and pass the data through classes
 */
public class ClientDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long clientID;
	private String name;
	private String lastName1;
	private String lastName2;
	private DocumentTypeDTO docType;
	private String docNumber;
	private String address;
	private Integer age;
	private Long phone;
	private Long cellPhone;

	/**
	 * Basic constructor
	 * 
	 * @author Jonathan.Barrera
	 */
	public ClientDTO() {
		super();
	}
	

	/**
	 * @return the clientID
	 */
	public Long getClientID() {
		return clientID;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
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
	 * @return the lastName1
	 */
	public String getLastName1() {
		return lastName1;
	}

	/**
	 * @param lastName1 the lastName1 to set
	 */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}

	/**
	 * @param lastName2 the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	/**
	 * @return the docType
	 */
	public DocumentTypeDTO getDocType() {
		return docType;
	}

	/**
	 * @param docType the docType to set
	 */
	public void setDocType(DocumentTypeDTO docType) {
		this.docType = docType;
	}

	/**
	 * @return the docNumber
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @param docNumber the docNumber to set
	 */
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the phone
	 */
	public Long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	/**
	 * @return the cellPhone
	 */
	public Long getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellphone the cellPhone to set
	 */
	public void setCellPhone(Long cellphone) {
		this.cellPhone = cellphone;
	}

	@Override
	public String toString() {
		return "ClientDTO [clientID=" + clientID + ", name=" + name + ", lastName1=" + lastName1 + ", lastName2="
				+ lastName2 + ", docType=" + docType + ", docNumber=" + docNumber + ", address=" + address
				+ ", birthDate=" + age + ", phone=" + phone + ", cellPhone=" + cellPhone + "]";
	}
	
		

}
