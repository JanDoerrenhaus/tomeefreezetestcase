package de.incub8.tomeefreezetestcase;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;

@Stateless
public class EventDispatcher
{
    @Asynchronous
    public <T> void fire(Event<T> event, T parameter)
    {
        event.fire(parameter);
    }
}