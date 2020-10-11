package co.com.gamestore.pos.services.main.model;

import co.com.gamestore.framework.response.BaseResponse;

/**
 * 
 * @author Jonathan.Barrera
 *	DTO to save user information and pass the data through classes
 */
public class UserDTO extends BaseResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userID;
	private String userName;
	private String lastName1;
	private String lastName2;
	private String userDocument;;
	private Integer userDocumentType;
	
	/**
	 * Basic constructor
	 * @author Jonathan.Barrera
	 */
	public UserDTO() {
		super();
	}
	
	/**
	 * Basic constructor with all attributes
	 * @param userID
	 * @param userName
	 * @param lastName1
	 * @param lastName2
	 * @param userDocument
	 * @param userDocumentType
	 */
	public UserDTO(Long userID, String userName, String lastName1, String lastName2, String userDocument,
			Integer userDocumentType) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.userDocument = userDocument;
		this.userDocumentType = userDocumentType;
	}


	/**
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the userDocument
	 */
	public String getUserDocument() {
		return userDocument;
	}
	/**
	 * @param userDocument the userDocument to set
	 */
	public void setUserDocument(String userDocument) {
		this.userDocument = userDocument;
	}
	/**
	 * @return the userDocumentType
	 */
	public Integer getUserDocumentType() {
		return userDocumentType;
	}
	/**
	 * @param userDocumentType the userDocumentType to set
	 */
	public void setUserDocumentType(Integer userDocumentType) {
		this.userDocumentType = userDocumentType;
	}
	@Override
	public String toString() {
		return "UserDTO [userID=" + userID + ", userName=" + userName + ", userDocument=" + userDocument
				+ ", userDocumentType=" + userDocumentType + "]";
	}
	
	
	
	 

}
