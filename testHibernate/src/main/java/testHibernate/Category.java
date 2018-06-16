package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 나중에 추가적으로 db에 저장할것이다라고 hibernate에게 알려준다.
public class Category {

	@Id // 프라이머리키로 설정하겠다.
	@GeneratedValue // 키값 자동으로 생성하겠다
	private int id;

	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 카테고리입장에서는 하나의 카테고리에 여러개의
																							// product가 있음, mappedby는
	// product에서 어떤게 foreign key를 갖는지 연결을 알려줘야함.
	// category를 지우면 product가 날라간다.(cascade 덕분), fetch란 lazy의 경우 category를 읽을 때
	// product는 안읽는다는 것 다읽으면 퍼포먼스적으로 안좋기 때문이다. EAGER을 사용하면 다 읽는다. 결과는 동일.
	private Set<Product> products = new HashSet<Product>();
}
