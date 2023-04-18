package pointman.springmvc_jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pointman.springmvc_jpa.hellojpa.repository.MemberRepository;
import pointman.springmvc_jpa.hellojpa.repository.repositoryImpl.MemberRepositoryImpl;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberRepository memberRepository(){return new MemberRepositoryImpl(em);
    }

}
