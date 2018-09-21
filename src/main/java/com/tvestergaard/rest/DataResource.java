package com.tvestergaard.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("data")
public class DataResource
{

    @GET
    @Path("{n: [0-9]+}/{startingId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt(@PathParam("n") int n, @PathParam("startingId") int startingId)
    {
        return Response.ok()
                       .entity(Generator.generate(n, startingId))
                       .build();
    }
}
