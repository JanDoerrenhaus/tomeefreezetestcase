package de.incub8.tomeefreezetestcase;

import javax.ejb.Asynchronous;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.event.Event;

import lombok.extern.slf4j.Slf4j;

@Singleton
@Lock(LockType.READ)
@Slf4j
public class EventDispatcher
{
    @Asynchronous
    public <T> void fire(Event<T> event, T parameter)
    {
        log.info("Firing event.");
        event.fire(parameter);
    }
}