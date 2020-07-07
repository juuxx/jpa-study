package com.juustudy;

import com.juustudy.domain.Member;
import com.juustudy.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //메인생성 단축키 psvm

        //엔티티 매니저 팩토리 - 생성
        //persistence.xml에서 설정한 이름 <persistence-unit name="juustudy">
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("juustudy");
        //엔티디 매니저 - 생성
        EntityManager em = emf.createEntityManager();
        //트랜잭션 - 획득
        EntityTransaction tx = em.getTransaction();
        try {
            /*
            연관관계 매핑의 필요성
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId);

            //위의 해당 아이디로 찾은 오더에서 그 멤버 아이디를 가지고 있는 멤버를 가져온다
            //아이디 -> Order 찾음 -> 그 order에 해당하는 emberid를 가지고 있는 member를 가져옴

            Member findMember = order.getMember();

            */

            //tx.begin(); //트랜잭션 - 시작
            // logic(em); //비지니스 로직 실행
            tx.commit(); //트랜잭션 - 커밋
        } catch (Exception e){
            tx.rollback(); //트랜잭션 롤백
        }finally {
            em.close(); //엔티티 매니저 - 종료
        }
        emf.close(); //엔티티 매니저 팩토리 - 종료
    }
}
