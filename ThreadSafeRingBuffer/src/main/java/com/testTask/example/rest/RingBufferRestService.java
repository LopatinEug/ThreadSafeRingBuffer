package com.testTask.example.rest;

import com.testTask.example.api.Consumer;
import com.testTask.example.api.Producer;
import com.testTask.example.api.RingBuffer;
import com.testTask.example.impl.ThreadSafeRingBuffer;
import com.testTask.example.impl.ThreadService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Path("/elements")
public class RingBufferRestService {
    RingBuffer buffer;

    public RingBufferRestService() {
        buffer= new ThreadSafeRingBuffer(10);
        ThreadService service=new ThreadService(buffer);
        service.runPeriodically(3);
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getBufferElements(){
        return buffer.getElements();
    }
}