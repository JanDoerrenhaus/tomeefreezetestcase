package de.incub8.tomeefreezetestcase;

import javax.ejb.Asynchronous;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@Lock(LockType.READ)
public class CopyOfDerivedDataCreator
{
    @Asynchronous
    public void onSignalEntityCreated(@Observes DerivedDataEntity derivedDataEntity)
    {
        log.info("Reacting to derived data entity created event.");
        CopyOfDerivedDataEntity entity = new CopyOfDerivedDataEntity(derivedDataEntity);
    }
}