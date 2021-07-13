package in.HealthAndGlowbel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author B Shashidhar
 *
 * 
 */
@Entity
@Table(name = "USER_LOGIN", uniqueConstraints = { @UniqueConstraint(columnNames = { "USER_LOGIN_ID", "USER_MOBILE" }) })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long user_Id;
	@NotNull
	@Column(name = "USER_LOGIN_ID", unique = true)
	private String user_Login_Id;
	@Column(name = "CURRENT_PASSWORD")
	private String current_Password;
	@Column(name = "USER_MOBILE", unique = true)
	private String user_Mobile;
	@Column(name = "USER_AUTH_TOKEN")
	private String user_Auth_Token;
	@Column(name = "USER_STATUS")
	private String user_Status;
	@Column(name = "CREATED_STAMP")
	@CreationTimestamp
	private Date created_Stamp;
	@Column(name = "LAST_UPDATED_STAMP", updatable = false)
	@CreationTimestamp
	private Date last_Update_Stamp;
}
