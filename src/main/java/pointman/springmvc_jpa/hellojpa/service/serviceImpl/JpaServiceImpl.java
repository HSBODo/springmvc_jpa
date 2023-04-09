package pointman.springmvc_jpa.hellojpa.service.serviceImpl;

import org.springframework.stereotype.Service;
import pointman.springmvc_jpa.hellojpa.Member;
import pointman.springmvc_jpa.hellojpa.service.JpaService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
@Service
public class JpaServiceImpl implements JpaService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Override
    public Member save(Member member) {
        tx.begin();
        try {
            em.persist(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();

        }finally {
            em.close();
            emf.close();
            return member;
        }
    }
}
