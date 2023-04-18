package pointman.springmvc_jpa.hellojpa.domain;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity(name="Member") //같은 이름의 클래스가 있으면 name을 설정하여 이름을 변경
@Table(name = "tb_member")// 객체와 table 매핑
@Getter @Setter
@NoArgsConstructor //기본생성자 필수
@Inheritance(strategy = InheritanceType.JOINED)
//final, enum, interface, inner 클래스 사용불가
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(insertable = false) 데이터베이스에 insert 할건지 여부
    //@Column(updatable = false) ) 데이터베이스에 update 할건지 여부
    //@Column(nullable = false) false= NOT NULL
    //@Column(columnDefinition = "varchar(100) default 'EMPTY'") 컬럼 정보를 직접 설정
    //@Column(precision = 10,scale = 5) precision는 소수점 포함 전체 자리수 scale은 소수점 자리수 dobule, float타입 적용안됨
    private BigDecimal bigNum;
    @Column(name = "user_name")
    private String name; // 저장할 필드에 final 사용불가
    @Column(unique = true,length = 11)
    private String phone; //유니크 및 길이 설정
    /**
        @Enumerated(EnumType.ORDINAL) enum의 순서를 데이터베이스에 저장
        @Enumerated(EnumType.STRING) enum의 이름을 데이터베이스에 저장 enum이 추가되면 순서가 바뀌기 때문에 STRING으로 사용할 것
      */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    /**
     @Temporal(TemporalType.DATE) 2023-01-12 날짜
     @Temporal(TemporalType.TMIE) 22:30:45 시간
     @Temporal(TemporalType.TIMESTAMP) 날짜+시간 2023-01-12 22:30:45
     java8 이상 최신 하이버네이트는 LocalDate, LocalDateTime 지원해서 사용 안해도 된다
     */
    @Temporal(TemporalType.TIMESTAMP) //날짜 타입
    private Date createdDate;

    private LocalDate lastModifiedDate;
    @Lob
    private String description; //varchar 보다 큰 데이터타입
    @Transient
    private int temp;//DB와 매핑하지 않는다 제외조건 메모리상에서만 임시로 어떠 값을 보관하고 싶을 때

}
