package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
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

//            Member member = new Member();
//            member.setCreatedBy("kim");
//            member.setUsername("user");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Member member = em.find(Member.class, 1L);
//            printMember(member);
//            printMemberAndTeam(member);

/*
            Member member = new Member();
            member.setUsername("hello");
            em.persist(member);
            em.flush();
            em.clear();
            //
//            Member findMember = em.find(Member.class, member.getId());
            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember = " + findMember.getClass());
            System.out.println("findMember.getId() = " + findMember.getId()); // 이 시점에는 select 쿼리가 나가지 않는다. id의 경우는 getReference() 의 파라미터로 값으로 이미 넘겨줬음
            System.out.println("findMember.getUsername() = " + findMember.getUsername());
            System.out.println("findMember.getUsername() = " + findMember.getUsername());
*/

/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            em.persist(member2);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            Member m2 = em.getReference(Member.class, member2.getId());

            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));  // 출력결과 : m1 == m2 : false
            System.out.println("m1 == m2 : " + (m1 instanceof Member));  // 출력결과 : m1 == m2 : true
            System.out.println("m1 == m2 : " + (m2 instanceof Member));  // 출력결과 : m1 == m2 : true
*/

/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            System.out.println("m1 = " + m1.getClass());  // 출력결과 -> m1 = class hellojpa.Member

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference = " + reference.getClass());  // 출력결과 -> reference = class hellojpa.Member
            System.out.println("a == a : " + (m1 == reference));  // 출력결과 -> a == a : true
*/

/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass());  // 출력결과 -> refMember = class hellojpa.Member$HibernateProxy$DkhP7QqA

            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember = " + findMember.getClass());  // 출력결과 -> findMember = class hellojpa.Member$HibernateProxy$DkhP7QqA
            System.out.println("refMember == findMember : " + (refMember == findMember));  // 출력결과 -> refMember == findMember : true
            // 결과가 true 이고 refMember 와 findMember 가 같은 proxy로 반환되는 이유는
            // JPA에서는 같은 영속성 컨텍스트(같은 트랜잭션) 안에서 같은 객체의 `==` 비교시 true를 보장해야한다.
*/

/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); // proxy

            em.detach(refMember);  // 혹은 em.close();  혹은 em.clear();

            refMember.getUsername();  // 에러 발생
*/

/*
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass());  // 출력결과 -> refMember = class hellojpa.Member$HibernateProxy$ixJ7bSYG

            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));  // 출력결과 -> isLoaded = false
            Hibernate.initialize(refMember);  // 강제초기화
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));  // 출력결과 -> isLoaded = true
*/

/*
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);

            em.persist(member1);

            em.flush();
            em.clear();

            Member m = em.find(Member.class, member1.getId());

            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());
            m.getTeam().getName();  // lazyLoading시 초기화 실행시점 (`Team`에 대한 select 쿼리가 실행되는 시점)

            System.out.println("teamName = " + m.getTeam().getName());
*/

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);

            em.persist(member1);

            em.flush();
            em.clear();

//            Member m = em.find(Member.class, member1.getId());

            List<Member> result = em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList();

            tx.commit(); // DB에 쿼리 날리는 시점
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
           em.close();  // 내부적으로 database connection을 물고 있기 때문에 끝나면 꼭 닫아줘야한다.
        }

        // WAS 가 내려갈때 EntityManagerFactory를 닫아줘야한다.(그래야 connection pooling 등이 내부적으로 release가 된다.)
        emf.close();

    }

    private static void printMember(Member member) {
        System.out.println("member = " + member);
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team);
    }

}