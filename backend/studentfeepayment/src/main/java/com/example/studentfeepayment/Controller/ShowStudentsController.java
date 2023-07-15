package com.example.studentfeepayment.Controller;

import com.example.studentfeepayment.Bean.Students;
import com.example.studentfeepayment.DAO.DAOImplementation.StudentDAOImpl;
import com.example.studentfeepayment.DAO.StudentDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URISyntaxException;
import java.util.List;
@Path("/student")
public class ShowStudentsController {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Students student) {
        StudentDAO studentDAO=new StudentDAOImpl();
        Students loggedInStudent = studentDAO.login(student);
        if (loggedInStudent == null)
            return Response.status(401).build();
        else
            return Response.ok().entity(loggedInStudent).build();
    }

    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Students> showname()  {
        System.out.println("Request for showing first names of students ");
        List<Students> response = new StudentDAOImpl().show();
        return response;
    }
}
