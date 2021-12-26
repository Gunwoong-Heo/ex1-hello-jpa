package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "USER")   // DB 테이블 명이 다를 경우
public class Member {

    @Id
    private Long id;
//    @Column(name = "username")  // 테이블의 column명을 명시적으로 표기하는 경우
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}