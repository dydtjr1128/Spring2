package kr.ac.hansung.cse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@NotEmpty(message="The username must not be null")
	private String username;
	
	@NotEmpty(message="The password must not be null")
	private String password;
	
	@NotEmpty(message="The email must not be null")
	private String email;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)//optional = false갑이 반드시 있어야한다.
	@JoinColumn(unique=true)
	private ShippingAdress shippingAddress;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)//optional = false갑이 반드시 있어야한다.
	@JoinColumn(unique=true) 
	private Cart cart;
	
	private boolean enabled = false;
	
	private String authority;
}
