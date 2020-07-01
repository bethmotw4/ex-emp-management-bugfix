package jp.co.sample.emp_management.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message = "名前を入力してください")
	private String name;
	/** メールアドレス */
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスの形式が不正です")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "パスワードを入力してください")
	@Length(min = 5, message = "5文字以上入力してください")
	private String password;
	/** 確認用パスワード */
//	@NotBlank(message = "確認用パスワードを入力してください")
	private String confirmationPasswaord;
	@AssertTrue(message = "パスワードが不一致です")
	public boolean isconfirmationPasswaordValid() {
		if (StringUtils.isEmpty(password)) {
			return true;
		}
		if (!password.equals(confirmationPasswaord)) {
			return false;
		}
		return true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmationPasswaord() {
		return confirmationPasswaord;
	}
	public void setConfirmationPasswaord(String confirmationPasswaord) {
		this.confirmationPasswaord = confirmationPasswaord;
	}
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ ", confirmationPasswaord=" + confirmationPasswaord + "]";
	}
	
	
}
