package com.juustudy.domain;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("juustudy");
    //엔티디 매니저 - 생성
    EntityManager em = emf.createEntityManager();
    @Test
    public void whenOrderRequestIsDeleted_thenDeleteShipmentInfo() {
        createOrderRequestWithShipmentInfo();

        OrderRequest orderRequest = em.find(OrderRequest.class, 1L);

        em.getTransaction().begin();
        em.remove(orderRequest);
        em.getTransaction().commit();

        assertEquals(0, findAllOrderRequest().size());
        assertEquals(0, findAllShipmentInfo().size());
    }

    private void createOrderRequestWithShipmentInfo() {
        ShipmentInfo shipmentInfo = new ShipmentInfo("name");
        OrderRequest orderRequest = new OrderRequest(shipmentInfo);

        em.getTransaction().begin();
        em.persist(orderRequest);
        em.getTransaction().commit();

        assertEquals(1, findAllOrderRequest().size());
        assertEquals(1, findAllShipmentInfo().size());
    }

}