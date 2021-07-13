package in.HealthAndGlowbel.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
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
@Table(name = "HNG_BASKET")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "USER_ID"), referencedColumnName = "USER_ID", nullable = true)
	private User user_Id;
	
	@Column(name = "NO_OF_ITEMS")
	@ColumnDefault("1")
	private Short no_Of_Items;
	@Column(name = "GRAND_TOTAL", nullable = true)
	private Float grand_Total;
	@Column(name = "DELIVERY_CHARGE", nullable = true)
	private Float delivery_Charge;
	@Column(name = "APPLIED_COUPON_CODE", nullable = true)
	private String applied_Coupon_Code;
	@Column(name = "COUPON_AMOUNT", nullable = true)
	private Float coupon_Amount;
	@Column(name = "CREATED_STAMP")
	@CreationTimestamp
	private Date created_Stamp;
	@Column(name = "LAST_UPDATED_STAMP", updatable = false)
	@CreationTimestamp
	private Date last_Update_Stamp;
}
