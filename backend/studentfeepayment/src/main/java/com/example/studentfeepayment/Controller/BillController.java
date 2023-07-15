package com.example.studentfeepayment.Controller;

import com.example.studentfeepayment.Bean.Bills;
import com.example.studentfeepayment.Bean.Receipt;
import com.example.studentfeepayment.DAO.BillsDAO;
import com.example.studentfeepayment.DAO.DAOImplementation.BillDAOImpl;
import com.example.studentfeepayment.services.BillService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.List;

@Path("/bill")
public class BillController {

    @GET
    @Path("/getbills/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbills(@PathParam("studentId") int studentId)  {
        System.out.println("Request for showing bill of students having studentId "+ studentId);
        BillsDAO billsList = new BillDAOImpl();
        List<Bills> list= billsList.getBills(studentId);
        return Response.ok().entity(list).build();
    }

    @POST
    @Path("/pay")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response paybills(HashMap<Integer, Receipt> paymentDictionary) {
        Integer successfulPayments;
        successfulPayments= new BillService().payBills(paymentDictionary);
//
        if (successfulPayments == paymentDictionary.size())
            return Response.ok().build();
        else
            // Return OK status code but 202 = There's no guarantee everything panned out as it should
            return Response.status(202).entity(paymentDictionary).build();
    }

}
