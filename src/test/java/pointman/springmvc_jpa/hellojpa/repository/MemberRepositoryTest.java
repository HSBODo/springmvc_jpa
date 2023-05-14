package pointman.springmvc_jpa.hellojpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import pointman.springmvc_jpa.hellojpa.domain.Member;
import pointman.springmvc_jpa.hellojpa.domain.Team;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Transactional
class MemberRepositoryTest {
    @Autowired
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;
    @Test
    @Commit
    void save(){
        Team team = new Team();
        team.setName("TeamA");
        em.persist(team);
        Member member =new Member();
        member.setName("테스트1");
        member.setTeam(team);
        Member savedMember = memberRepository.save(member);
        Assertions.assertThat(savedMember).isEqualTo(member);
    }

    @Test
    @Commit
    void find() {
        Long id = 4L;
        Member findMember = memberRepository.find(id);
        Team findTeam = findMember.getTeam();
        List<Member> members = findTeam.getMembers();

        for (Member member : members) {
            log.info("member={}",member.getId());
        }
        Assertions.assertThat(findMember.getTeam()).isEqualTo(findTeam);
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