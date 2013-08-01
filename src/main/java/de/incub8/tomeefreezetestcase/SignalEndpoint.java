package de.incub8.tomeefreezetestcase;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import lombok.extern.slf4j.Slf4j;

@Stateless
@Path("signal")
@Slf4j
public class SignalEndpoint
{
    @Inject
    private SignalStore store;

    @POST
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
}