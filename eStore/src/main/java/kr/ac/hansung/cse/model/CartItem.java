package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class CartItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7296960050350583877L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	@JsonIgnore/*Cart에 CartItem이 있고, CartItem에서 읽으면 또 Cart가 또있어 Cycle이 생김 무한반복 그래서 안읽도록 하는 어노테이션*/
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	private int quantity;
	
	private double totalPrice;
}
