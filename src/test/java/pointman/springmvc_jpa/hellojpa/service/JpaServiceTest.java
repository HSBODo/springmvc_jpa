package pointman.springmvc_jpa.hellojpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import pointman.springmvc_jpa.hellojpa.domain.Member;
import pointman.springmvc_jpa.hellojpa.repository.MemberRepository;
import pointman.springmvc_jpa.hellojpa.repository.repositoryImpl.MemberRepositoryImpl;
import pointman.springmvc_jpa.hellojpa.service.serviceImpl.JpaServiceImpl;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JpaServiceTest {
    EntityManager em;
    MemberRepository memberRepository;

    public JpaServiceTest(EntityManager em, MemberRepository memberRepository) {
        this.em = em;
        this.memberRepository =  new MemberRepositoryImpl(em);;
    }

    @Test
    @Commit
    void save(){
        Member member =new Member();
        member.setName("테스트 ");
        memberRepository.save(member);
    }

}