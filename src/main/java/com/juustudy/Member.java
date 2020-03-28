package com.juustudy;

import com.juustudy.RoleType;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@lombok.Setter
@lombok.Getter

@Entity
@Table(name="MEMBER")
public class Member {

    @Id
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) //EnumType.ORDINAL 사용 x
    //Enum 안의 index 값을 db에 넣는데, 만약에 USER, ADMIN 이였다가 GUEST, USER, ADMIN으로 바뀌면
    //구 데이터는 USER값이 0 신데이터는 GUEST값이 0으로 바뀌어서 데이터가 꼬이게 됨
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob //varchar를 넘어서는 큰 컨텐츠
    private String description;

    @Transient //db와 상관 없는 메모리에서만 사용
    private int temp;


    public Member() {
    }



}
