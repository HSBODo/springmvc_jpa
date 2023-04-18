package pointman.springmvc_jpa.hellojpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import pointman.springmvc_jpa.hellojpa.domain.Member;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Test
    @Commit
    void save(){
        Member member =new Member();
        member.setName("테스트 ");
        Member savedMember = memberRepository.save(member);
        Assertions.assertThat(savedMember).isEqualTo(member);
    }

    @Test
    @Commit
    void find() {
        Long id = 1L;
        Member findMember = memberRepository.find(id);
        Assertions.assertThat(findMember.getId()).isEqualTo(1L);
    }

    @Test
    @Commit
    void detach() {
        Long id = 2L;
        String name = "이름 업데이트";
        Member findMember = memberRepository.detach(id,name);
        log.info("findMember={}",findMember.getName());
    }
    @Test
    void delete(){
        Long id = 1L;
        memberRepository.delete(id);
    }
}