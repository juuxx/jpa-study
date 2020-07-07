package com.juustudy.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue()
    @Column(name="ORDER_ID")
    private Long id;
    @Column(name="MEMBER_ID")
    private Long memberId;// 이런 설계는 관계형 디비에 맞춰서 짠 거지.. 객제지향 스럽지 않음...

    /*
    * 현재 방식은 개게 설계를 테이블 설계에 맞춘 방식
    * ex) join 하기 위한 key 값 들을 엔티티에 넣어줌 (예를 들어 위의 memberId)
    * 테이블의 외래키를 객체에 그대로 가져옴
    * 객체 그래프 탐색이 불가능(바로 못가져오고 식별자(memberid)만 가져옴
    * 참조가 없으므로 uml도 잘못됨
    * -> 연관관계 매핑!! 이 필요.
    */

    private Member member;

    private LocalDateTime orderDate; //order_date, ORDER_DATE
    //spring boot hibernate 기본 설정이 자동으로 언더바 바꿔줌

    @Enumerated(EnumType.STRING) //enum
    private OrderStatus status;


    public Member getMember() {
        return member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
