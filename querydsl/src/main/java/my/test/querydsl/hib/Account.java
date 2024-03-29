package my.test.querydsl.hib;

//Generated Aug 26, 2013 10:07:55 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
* Account generated by hbm2java
*/
@Entity
@Table(name = "account", catalog = "invdb", uniqueConstraints = @UniqueConstraint(columnNames = "email_addr"))
public class Account implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8855716485228744367L;
	private Long accountId;
	private String emailAddr;
	private String alternateEmail;
	private String password;
	private String salt;
	private String firstName;
	private String lastName;
	private String middleName;
	private byte[] picture;
	private Long registrationAddrId;
	private Long billingAddrId;
	private Byte status;
	private Byte language;
	private Byte currencyCodeIso3;
	private String roles;
	private Date createdDate;
	private Date lastModifiedDate;
	private Byte lastModifiedApp;

	public Account() {
	}

	public Account(String emailAddr, String password, String salt,
			String firstName) {
		this.emailAddr = emailAddr;
		this.password = password;
		this.salt = salt;
		this.firstName = firstName;
	}

	public Account(String emailAddr, String alternateEmail, String password,
			String salt, String firstName, String lastName, String middleName,
			byte[] picture, Long registrationAddrId, Long billingAddrId,
			Byte status, Byte language, Byte currencyCodeIso3, String roles,
			Date createdDate, Date lastModifiedDate, Byte lastModifiedApp) {
		this.emailAddr = emailAddr;
		this.alternateEmail = alternateEmail;
		this.password = password;
		this.salt = salt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.picture = picture;
		this.registrationAddrId = registrationAddrId;
		this.billingAddrId = billingAddrId;
		this.status = status;
		this.language = language;
		this.currencyCodeIso3 = currencyCodeIso3;
		this.roles = roles;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedApp = lastModifiedApp;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Column(name = "email_addr", unique = true, nullable = false, length = 128)
	public String getEmailAddr() {
		return this.emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	@Column(name = "alternate_email", length = 128)
	public String getAlternateEmail() {
		return this.alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	@Column(name = "password", nullable = false, length = 512)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", nullable = false, length = 128)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "first_name", nullable = false, length = 64)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 64)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "middle_name", length = 64)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "picture")
	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Column(name = "registration_addr_id")
	public Long getRegistrationAddrId() {
		return this.registrationAddrId;
	}

	public void setRegistrationAddrId(Long registrationAddrId) {
		this.registrationAddrId = registrationAddrId;
	}

	@Column(name = "billing_addr_id")
	public Long getBillingAddrId() {
		return this.billingAddrId;
	}

	public void setBillingAddrId(Long billingAddrId) {
		this.billingAddrId = billingAddrId;
	}

	@Column(name = "status")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Column(name = "language")
	public Byte getLanguage() {
		return this.language;
	}

	public void setLanguage(Byte language) {
		this.language = language;
	}

	@Column(name = "currency_code_iso3")
	public Byte getCurrencyCodeIso3() {
		return this.currencyCodeIso3;
	}

	public void setCurrencyCodeIso3(Byte currencyCodeIso3) {
		this.currencyCodeIso3 = currencyCodeIso3;
	}

	@Column(name = "roles", length = 128)
	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(name = "last_modified_app")
	public Byte getLastModifiedApp() {
		return this.lastModifiedApp;
	}

	public void setLastModifiedApp(Byte lastModifiedApp) {
		this.lastModifiedApp = lastModifiedApp;
	}

}

