package in.HealthAndGlowbel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "PRODUCT_MASTER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@NotNull
	@Column(name = "PRODUCT_ID")
	private String product_Id;
	@NotNull
	@Column(name = "CATEGORY_ID", nullable = true)
	@ColumnDefault("-1")
	private Short category_Id;
	@Column(name = "CATEGORY_NAME", nullable = true)
	private String category_Name;
	@Column(name = "PARENT_CATEGORY_LINK", nullable = true)
	private String parent_Category_Link;
	@NotNull
	@Column(name = "BRAND_ID")
	@ColumnDefault("-1")
	private Short brand_Id;
	@Column(name = "BRAND_NAME", nullable = true)
	private String brand_Name;
	@Column(name = "PRODUCT_TITLE", nullable = true)
	private String product_Title;
	@Column(name = "MRP_PRICE", nullable = true)
	private Float mrp_Price;
	@Column(name = "LIST_PRICE", nullable = true)
	private Float list_Price;
	@Column(name = "CREATED_STAMP", nullable = false, updatable = false)
	@CreationTimestamp
	private Date created_Stamp;
	@Column(name = "LAST_UPDATED_STAMP", nullable = false)
	@CreationTimestamp
	private Date last_Update_Stamp;
}
