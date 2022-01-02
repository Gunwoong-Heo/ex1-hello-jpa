package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "USER")   // DB 테이블 명이 다를 경우
//public class Member extends BaseEntity {
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD",
            joinColumns = @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")  // AddressList 와는 달리 값이 하나고 정의한 값이 아니기 때문에 이 시점에 변경 가능
    private Set<String> favoriteFoods = new HashSet<>();

    /*
    //    @OrderColumn(name = "address_history_order")
        @ElementCollection()
        @CollectionTable(name = "ADDRESS",
                joinColumns = @JoinColumn(name = "MEMBER_ID")
        )
        private List<Address> addressHistory = new ArrayList<>();
    */

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

//    // 기간
//    @Embedded
//    private Period workPeriod;

/*
    // 주소
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
    })
    private Address workAddress;
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Period getWorkPeriod() {
//        return workPeriod;
//    }
//
//    public void setWorkPeriod(Period workPeriod) {
//        this.workPeriod = workPeriod;
//    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    /*
//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
*/

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

//    public List<Address> getAddressHistory() {
//        return addressHistory;
//    }
//
//    public void setAddressHistory(List<Address> addressHistory) {
//        this.addressHistory = addressHistory;
//    }


    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }
}