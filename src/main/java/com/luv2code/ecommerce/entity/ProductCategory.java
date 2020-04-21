package com.luv2code.ecommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class for Product_Category table using JPA
 * 
 * @author arnab
 *
 */

@Entity
@Table(name = "product_category")
@Getter
@Setter
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="table_name_prod_cat")
	@GenericGenerator(
	        name = "table_name_prod_cat",
	        strategy = "sequence",
    		parameters = {
                    @Parameter(name = "sequence_name", value = "table_name_prod_cat"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1"),
            })
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private Set<Product> products;
}
