package in.HealthAndGlowbel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@SuppressWarnings("serial")
@Entity
@Table(name = "BASKET_ITEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
	@Id
	@JoinColumn(name = "BASKET_ID", foreignKey=@ForeignKey( name = "ID"),referencedColumnName ="ID", nullable = false)
	@ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Basket.class)
	private Basket baskit_Id;
	@Id
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", nullable = false)
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Product.class)
	private Integer product_id;
	@Column(name = "QUANTITY")
	@ColumnDefault("1")
	private Short quantity;
	@Column(name = "MRP_PRICE", nullable = true)
	private Float mrp_Price;
	@Column(name = "LIST_PRICE", nullable = true)
	private Float list_Price;
	@Column(name = "PRODUCT_NAME", nullable = true)
	private String product_Name;
	@Column(name = "CREATED_STAMP")
	@CreationTimestamp
	private Date created_Stamp;
	@Column(name = "LAST_UPDATED_STAMP", updatable = false)
	@CreationTimestamp
	private Date last_Update_Stamp;
}
