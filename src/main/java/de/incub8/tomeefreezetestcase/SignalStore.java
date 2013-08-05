package de.incub8.tomeefreezetestcase;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignalStore
{
    @EJB
    private EventDispatcher dispatcher;

    @Inject
    private Event<SignalEntity> created;

    public void createSignal()
    {
        SignalEntity entity = new SignalEntity();
        log.info("Signal created, firing event.");
        dispatcher.fire(created, entity);
    }
}