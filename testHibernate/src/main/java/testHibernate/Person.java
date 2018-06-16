package testHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {
		@Id
		@GeneratedValue
		private int id;
		
		private String firstName;
		private String lastName;
		
		@OneToOne(mappedBy="person", cascade=CascadeType.ALL)//person저장하면 license도 자동적으로 저장된다.
		private License license;
}
