package pointman.springmvc_jpa.hellojpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Slf4j
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("helloA");
            List<Member> findMembers = em.createQuery("select m from Member as m ", Member.class)
                    .setFirstResult(1) //최소
                    .setMaxResults(8)   //최대
                    .getResultList();
            for (Member findMember : findMembers) {
                log.info("member={}",findMember.getName());
            }
//            Member findMember = em.find(Member.class, 1L); //SELECT

//            findMember.setName("홍길동"); //update 조회한 객체 이름만 변경으로 자동으로 업데이트 된다

//            em.remove(findMember);// DELETE

//            log.info("findMember={}",findMember.getName());
            
//            em.persist(member); //INSERT
            tx.commit();
        }catch (Exception e){
            tx.rollback();

        }finally {
            em.close();
            emf.close();
        }



    }
}
