package jpawithmybatis.jpasrc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder // MemberEntity.builder() 코드 사용시 적용
@Setter // 클래스 생성시 적용
@Getter // 클래스 생성시 적용

@NoArgsConstructor
@Entity // 객체와 테이블 매핑
@Table(name = "IDS") // 테이블 지정
public class IdsEntity {
	@Id  // Primary Key 지정
	@NotNull
	@Column(name = "TABLE_NAME")
	private String table_name;

	@NotNull
	@Column(name = "NEXT_ID")
	private String next_id;
}
