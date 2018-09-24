package com.tvestergaard.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("data")
public class DataResource
{

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("{n: [0-9]+}/{startingId: [0-9]+}")
    @Produces(APPLICATION_JSON)
    public Response getIt(@PathParam("n") int n, @PathParam("startingId") int startingId)
    {
        return Response.ok()
                       .entity(Generator.generate(n, startingId))
                       .build();
    }

    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public Response post(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName)
    {

        PostResponse postResponse = new PostResponse();

        if (firstName != null && !firstName.isEmpty()) {
            Generator.addFirstName(firstName);
            postResponse.firstName = firstName;
        }

        if (lastName != null && !lastName.isEmpty()) {
            Generator.addLastName(lastName);
            postResponse.lastName = lastName;
        }

        return Response.status(Response.Status.CREATED).entity(gson.toJson(postResponse)).build();
    }

    private class PostResponse
    {
        public String firstName;
        public String lastName;
    }
}
