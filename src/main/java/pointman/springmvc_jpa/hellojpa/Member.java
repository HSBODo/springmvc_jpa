package pointman.springmvc_jpa.hellojpa;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
public class Member {
    @Id
    private Long id;
    private String name;
}
