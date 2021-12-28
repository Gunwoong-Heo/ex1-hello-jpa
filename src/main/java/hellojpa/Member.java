package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "USER")   // DB 테이블 명이 다를 경우
public class Member {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

}