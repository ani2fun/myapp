package org.tiger.PhoneBookDemo.resources;

import org.skife.jdbi.v2.DBI;
import org.tiger.PhoneBookDemo.dao.ContactDAO;
import org.tiger.PhoneBookDemo.representations.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by aniket on 3/2/16.
 */

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {


    private final ContactDAO contactDao;
    public ContactResource(DBI jdbi) {
        contactDao = jdbi.onDemand(ContactDAO.class);
    }

    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {

        // retrieve information about the contact with the provided id

        Contact contact = contactDao.getContactById(id);
        return Response.ok(contact).build();
    }


    @POST
    public Response createContact(Contact contact) {
        return Response.created(null).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") int id, Contact contact) {

        return Response.ok(new Contact(id,contact.getFirstName(),contact.getLastName(),contact.getPhone())).build();

    }

}

