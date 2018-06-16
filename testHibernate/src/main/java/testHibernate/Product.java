package testHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity//이 Class에 해당되는 내용을 Hibernate가 인지하고 테이블을 만들어줌
@Table(name="Product")//테이블 이름을 명시하고 싶을때 사용 없으면 클래스 이름으로 생성된다.
public class Product {
	
	@Id
	@GeneratedValue//이 int id라고 하는값을 @Id로 Primary key로 설정하고, @GeneratedValue로 자동으로 생성한다.
	@Column(name="product_id")//컬럼 이름 설정 할 수 있다.
	private int id;
	
	private String name;
	
	private int price;
	
	private String description;
	
	@ManyToOne//product쪽이 many쪽이므로 설정, cascade가 all이면 persist(저장)나 delete할때도 연관된 것까지 update된다.
	@JoinColumn(name="category_id")//이름 설정
	private Category category;
}
