package de.incub8.tomeefreezetestcase;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignalStore
{
    @PersistenceContext
    private EntityManager em;

    @EJB
    private EventDispatcher dispatcher;

    @Inject
    private Event<SignalEntity> created;

    public void createSignal()
    {
        SignalEntity entity = new SignalEntity();
        em.persist(entity);
        log.info("Signal created, firing event.");
        dispatcher.fire(created, entity);
    }
}