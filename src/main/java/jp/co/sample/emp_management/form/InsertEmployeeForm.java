package jp.co.sample.emp_management.form;

//import java.sql.Date;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 従業員登録に使用するフォーム.
 * 
 * @author yoshiki.morimoto
 *
 */
public class InsertEmployeeForm {
	/** id */
	private Integer id;
	/** 従業員名 */
	@NotBlank(message = "名前が未入力です")
	private String name;
	/** 画像 */
	@NotBlank(message = "画像が未入力です")
	private String image;
	/** 性別 */
	@NotEmpty(message = "性別が未入力です")
	private String gender;
	/** 入社日 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "入社日が未入力です")
	private Date hireDate;
	/** メールアドレス */
	@NotBlank(message = "メールアドレスが未入力です")
	@Email(message = "メールアドレスの形式が不正です")
	private String mailAddress;
	/** 郵便番号 */
	@NotBlank(message = "郵便番号が未入力です")
	@Pattern(regexp = "^\\d{3}-\\d{4}$", message = "郵便番号の形式が不正です")
	private String zipCode;
	/** 住所 */
	@NotBlank(message = "住所が未入力です")
	private String address;
	/** 電話番号 */
	@NotBlank(message = "電話番号が未入力です")
	@Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "電話番号の形式が不正です")
	private String telephone;
	/** 給料 */
	@NotNull(message = "給料が未入力です")
	private Integer salary;
	/** 特性 */
	@NotBlank(message = "特性が未入力です")
	private String characteristics;
	/** 扶養人数 */
	@NotNull(message = "扶養人数が未入力です")
	private Integer dependentsCount;
	
	public InsertEmployeeForm() {
		super();
		gender = "男性";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public Integer getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(Integer dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "InsertEmployeeForm [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender
				+ ", hireDate=" + hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address="
				+ address + ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependentsCount=" + dependentsCount + "]";
	}
	
}
