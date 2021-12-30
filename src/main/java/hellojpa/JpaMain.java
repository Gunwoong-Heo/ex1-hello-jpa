package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
        // EntityManagerFactory는 웹서버가 올라오는 시점에서 DB당 1개만 생성되어 애플리케이션 전체에서 공유한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // EntityManager는 요청이 있을때마다, 생성이되고, 수행 완료되는 시점에서 close 해야 한다. (쓰레드간에 공유 X)
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            // 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            // 수정
            // JPA를 통해서 엔티티를 가져오게되면, jpa가 관리를 하게 된다. jpa가 가져온 대상의 변경여부를 transaction 커밋 직전에 체크를하고, 변경점이 있다면, update쿼리를 날리고 transaction 커밋을 한다.
//            Member findMember = em.find(Member.class, 2L);
//            findMember.setName("HelloJPA");

            // JPQL : JPA가 제공하는 SQL을 추상화한 객체지향 쿼리. 여러 DB에 맞게 DB방언을 대신 짜준다(persistence.xml 에서 H2Dialect->Oracle8iDialect 로 변경 후 테스트해보면 query가 달라진 것을 확인가능)

            // 실제 물리적인 DB테이블을 대상으로 query를 날려버리면, 해당 DB에 종속적인 설계가 되어버리는 문제가 있다.
            // 그래서 JPA는 객체를 대상으로 query를 할 수 있는 JPQL이라는 것이 제공되는 것이다. (SQL을 추상화해서 특정 데이터베이스 SQL에 의존하지 않는다.)
            // JPQL을 이용한 조회 예시
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5) // paging 처리 테스트
//                    .setMaxResults(8) // paging 처리 테스트
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(103L);
//            member.setName("HelloJPA");

            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member); // 이 시점에서는 영속성 컨텍스트 1차 캐시에 저장만 되고, DB에 쿼리는 날리지 않은 상태
//            em.detach(member); // member 객체를 영속성 컨텍스트에서 분리, 준영속 상태
//            em.remove(member); // 객체를 삭제한 상태
//            System.out.println("=== AFTER ===");

//            Member findMember = em.find(Member.class, 103L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            Member findMember1 = em.find(Member.class, 103L);
//            Member findMember2 = em.find(Member.class, 103L);
//            System.out.println("result = " + (findMember1 == findMember2));

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("===================");

//            Member member = em.find(Member.class, 150L);
//            member.setName("zzzz");

//            Member memberB = em.find(Member.class, 160L);
//            em.remove(memberB);

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team); // PK 값이 세팅 되고 영속상태가 됨
//
//            Member member = new Member();
//            member.setUsername("member1");
////            member.setTeamId(team.getId());
//            member.changeTeam(team);
//            em.persist(member);

//            team.getMembers().add(member);  // 주인이 아닌 쪽은 읽기전용으로 set을 해줘도 JPA가 반영을 안한다.

//            em.flush();
//            em.clear();

//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }
/*

            Member findMember = em.find(Member.class, member.getId());

//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());

            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }

*/

//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("고질라");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            em.find(Movie.class, movie.getId());

            Member member = new Member();
            member.setCreatedBy("kim");
            member.setUsername("user");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();

            tx.commit(); // DB에 쿼리 날리는 시점
        } catch (Exception e) {
            tx.rollback();
        } finally {
           em.close();  // 내부적으로 database connection을 물고 있기 때문에 끝나면 꼭 닫아줘야한다.
        }

        // WAS 가 내려갈때 EntityManagerFactory를 닫아줘야한다.(그래야 connection pooling 등이 내부적으로 release가 된다.)
        emf.close();

    }

}