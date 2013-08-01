package de.incub8.tomeefreezetestcase;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class CopyOfDerivedDataCreator
{
    @PersistenceContext
    private EntityManager em;

    @Asynchronous
    public void onSignalEntityCreated(@Observes DerivedDataEntity derivedDataEntity)
    {
        log.info("Reacting to derived data entity created event.");
        CopyOfDerivedDataEntity entity = new CopyOfDerivedDataEntity(derivedDataEntity);
        em.persist(entity);
    }
}