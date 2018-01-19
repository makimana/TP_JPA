package fr.istic.sir.rest;

import domain.Chauffage;
import domain.Equipement;
import domain.Personne;
import domain.Residence;
import service.PersonneDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class SampleWebService {

    PersonneDAO dao;
    public SampleWebService(){
        dao = new PersonneDAO();
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

    @GET
    @Path("/titi")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello1() {
        return "Coucou";
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Personne findPerson() {
        Personne p = new Personne();
        p.setPrenom("toto");
        p.setNom("titi");
        return p;
    }

    @POST
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Personne createPerson(Personne p) {
            return dao.create(p);
    }

    @GET
    @Path("/residence")
    @Produces(MediaType.APPLICATION_JSON)
    public Residence getHome() {
        Residence h = new Residence();
        h.setId(1);
        h.setTaille(450);
        h.setNb_pieces(6);
        Personne p = new Personne();
        p.getResidences().add(h);
        h.setSelf(p);
        Chauffage h1 = new Chauffage();
        h1.setId(1);
        h1.setPower("500w");
        h1.setName("Chauffage1");
        h1.setResidence(h);
        Chauffage h2 = new Chauffage();
        h2.setId(2);
        h2.setName("Chauffage2");
        h2.setPower("600w");
        h2.setResidence(h);
        h.addChauffage(h1);
        h.addChauffage(h2);
        return h;

    }
    @GET
    @Path("/equipement")
    @Produces(MediaType.APPLICATION_JSON)
    public Equipement findEquipement() {
        Equipement eq = new Equipement();
        eq.setId(1);
        eq.setName("nellya");
        Personne p = new Personne();
        p.getEquipements().add(eq);
        eq.setP(p);
        eq.setWatts(10);
        return eq;
    }
}

