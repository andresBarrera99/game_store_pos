package co.com.gamestore.pos.services.clients.model;

import java.util.Date;

import co.com.gamestore.framework.response.BaseResponse;

/**
 * 
 * @author Jonathan.Barrera
 * 
 *         DTO to save client information and pass the data through classes
 */
public class ClientDTO extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long clientID;
	private String name;
	private String lastName1;
	private String lastName2;
	private Integer docType;
	private String docNumber;
	private String address;
	private Date birthDate;
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
	 * Basic constructor with all attributes
	 * @param clientID
	 * @param name
	 * @param lastName1
	 * @param lastName2
	 * @param docType
	 * @param docNumber
	 * @param address
	 * @param birthDate
	 * @param phone
	 * @param cellphone
	 */
	public ClientDTO(Long clientID, String name, String lastName1, String lastName2, Integer docType, String docNumber,
			String address, Date birthDate, Long phone, Long cellphone) {
		super();
		this.clientID = clientID;
		this.name = name;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.docType = docType;
		this.docNumber = docNumber;
		this.address = address;
		this.birthDate = birthDate;
		this.phone = phone;
		this.cellPhone = cellphone;
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
	public Integer getDocType() {
		return docType;
	}

	/**
	 * @param docType the docType to set
	 */
	public void setDocType(Integer docType) {
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
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	 * @return the cellphone
	 */
	public Long getCellphone() {
		return cellPhone;
	}

	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(Long cellphone) {
		this.cellPhone = cellphone;
	}

	@Override
	public String toString() {
		return "ClientDTO [clientID=" + clientID + ", name=" + name + ", lastName1=" + lastName1 + ", lastName2="
				+ lastName2 + ", docType=" + docType + ", docNumber=" + docNumber + ", address=" + address
				+ ", birthDate=" + birthDate + ", phone=" + phone + ", cellPhone=" + cellPhone + "]";
	}
	
		

}
