package com.juustudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //엔티티 매니저 팩토리 - 생성
        //persistence.xml에서 설정한 이름 <persistence-unit name="juustudy">
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("juustudy");
        //엔티디 매니저 - 생성
        EntityManager em = emf.createEntityManager();
        //트랜잭션 - 획득
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin(); //트랜잭션 - 시작
            logic(em); //비지니스 로직 실행
            tx.commit(); //트랜잭션 - 커밋
        } catch (Exception e){
            tx.rollback(); //트랜잭션 롤백
        }finally {
            em.close(); //엔티티 매니저 - 종료
        }
        emf.close(); //엔티티 매니저 팩토리 - 종료
    }

    //비지니스 로직
    private static void logic(EntityManager em){

        Member member = new Member();
        member.setId(3L);
        member.setUsername("C");
        member.setRoleType(RoleType.GUEST);

        em.persist(member); //db에 저장
    }
}
