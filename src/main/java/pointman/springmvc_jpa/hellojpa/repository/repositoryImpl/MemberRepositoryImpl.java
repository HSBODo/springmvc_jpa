package pointman.springmvc_jpa.hellojpa.repository.repositoryImpl;

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
}
