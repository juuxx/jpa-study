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
@TableGenerator(name="MEMBER_SQE_GENERATOR",
                table="MY_SEQUNECE", //테이블 매핑 전략
                pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {
/*
* 권장하는 식별자 전략
* 기본키 제약 조건 : null 아님, 유일, 변하면 안된다.
* 미래까지 이 조건을 만족하는 자연키는 찾기 어렵다. 대리키(대체키)를 사용하자.
* 예를 들어 주민등록번호도 기본 키로 적절하지 않다.
* 권장 : LONG 형 + 대체키 + 키 생성전략 사용
*/
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE
                  , generator = "MEMBER_SQE_GENERATOR")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String username;

    public Member() {
    }



}
