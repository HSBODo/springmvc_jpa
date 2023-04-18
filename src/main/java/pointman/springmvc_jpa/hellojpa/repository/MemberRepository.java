package pointman.springmvc_jpa.hellojpa.repository;

import pointman.springmvc_jpa.hellojpa.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    Member find(Long id);
    Member detach(Long id,String updateParam);
    void delete(Long id);
}
