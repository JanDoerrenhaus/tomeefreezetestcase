package de.incub8.tomeefreezetestcase;

import java.io.IOException;
import java.net.URL;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;

import lombok.extern.slf4j.Slf4j;

@Path("signal")
@Slf4j
@Singleton
@Lock(LockType.READ)
public class SignalEndpoint
{
    @Inject
    private SignalStore store;

    @GET
    public void post()
    {
        store.createSignal();
    }

    @GET
    @Path("testcasecreatelotsofsignals")
    public void testCaseCreateLotsOfSignals()
    {
        for (int i = 0; i < 1000; i++)
        {
            log.info("i = {}", i);
            store.createSignal();
        }
    }

    @GET
    @Path("testcasebyweb")
    public void testCaseByWeb()
    {
        for (int i = 0; i < 1000; i++)
        {
            try
            {
                new URL("http://localhost:8080/tomeefreezetestcase/signal").openConnection().connect();
            }
            catch (IOException e)
            {
                throw new WebApplicationException(e);
            }
        }
    }
}