package de.incub8.tomeefreezetestcase;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@Lock(LockType.READ)
public class DerivedDataCreator
{
    @EJB
    private EventDispatcher dispatcher;

    @Inject
    private Event<DerivedDataEntity> created;

    @Asynchronous
    public void onSignalEntityCreated(@Observes SignalEntity signalEntity)
    {
        log.info("Reacting to signal entity created event.");
        DerivedDataEntity entity = new DerivedDataEntity(signalEntity);
        log.info("Created derived data entity, firing event.");
        dispatcher.fire(created, entity);
    }
}