/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import dto.ComplaintDto;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Zuza
 */
public class Main {
    public static void main() {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        
        Client client = ClientBuilder.newClient()
                .register(new JacksonJaxbJsonProvider(mapper, JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS));
        
        getCount(client);
        getAll(client);
        getOne(client);
        updateStatus(client);
        getAllOpen(client);
        
        client.close();
    }
    
    private static void getCount(Client client) {
        String count = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/count")
                        .request(MediaType.TEXT_PLAIN)
                        .get(String.class);

        System.out.println("Count: " + count);
    }
    
    private static void getAll(Client client) {
        List<ComplaintDto> complaints = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints")
                        .request(MediaType.APPLICATION_JSON)
                        .get(new GenericType<List<ComplaintDto>>() {
                        });

        System.out.println("Complaints: " + complaints.toString());
    }
    
    private static void getOne(Client client) {
        ComplaintDto complaint = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/355")
                        .request(MediaType.APPLICATION_JSON)
                        .get(ComplaintDto.class);

        System.out.println("Complaint id=355: " + complaint.toString());
    }
    
    private static void updateStatus(Client client) {
        ComplaintDto complaint = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/355")
                        .request(MediaType.APPLICATION_JSON)
                        .get(ComplaintDto.class);
        
        complaint.setStatus("closed");
        
        client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/355")
                        .request(MediaType.APPLICATION_JSON)
                        .put(Entity.entity(complaint, MediaType.APPLICATION_JSON));   

        System.out.println("Complaint id=355: " + complaint.toString());
    }
    
    private static void getAllOpen(Client client) {
        List<ComplaintDto> complaints = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints?status=open")
                        .request(MediaType.APPLICATION_JSON)
                        .get(new GenericType<List<ComplaintDto>>() {
                        });

        System.out.println("OPen complaints: " + complaints.toString());
    }
}
