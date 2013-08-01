package de.incub8.tomeefreezetestcase;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class DerivedDataCreator
{
    @PersistenceContext
    private EntityManager em;

    @EJB
    private EventDispatcher dispatcher;

    @Inject
    private Event<DerivedDataEntity> created;

    @Asynchronous
    public void onSignalEntityCreated(@Observes SignalEntity signalEntity)
    {
        log.info("Reacting to signal entity created event.");
        DerivedDataEntity entity = new DerivedDataEntity(signalEntity);
        em.persist(entity);
        log.info("Created derived data entity, firing event.");
        dispatcher.fire(created, entity);
    }
}