package pointman.springmvc_jpa.hellojpa.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import pointman.springmvc_jpa.hellojpa.domain.Member;
import pointman.springmvc_jpa.hellojpa.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class MemberRepositoryImpl implements MemberRepository {
    private final EntityManager em;

    public MemberRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member find(Long id) {
        Member findMember = em.find(Member.class, id);
        return findMember;
    }

    @Override
    public Member detach(Long id, String updateParam) {
        Member findMember = em.find(Member.class, id);// 쿼리 1번
        findMember.setName(updateParam);
        em.detach(findMember); //findMember가 영속성 컨텍스트에서 탈출 JPA에서 관리하지 않는다. 준영속성 상태
        //그 결과 Transaction 에서 commit 할 때 update가 되지 않는다.
        em.clear(); //용속성 컨텍스트에 모든 객체를 날린다.
        Member findMember2 = em.find(Member.class, id); //쿼리 2번 영속성 컨텍스트가 비워져 다시 조회
        return findMember;
    }

    @Override
    public void delete(Long id) {
        Member findMember = em.find(Member.class, id);
        em.remove(findMember);
    }
}
