package com.empresa.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.empresa.dao.CuentaDao;
import com.empresa.entities.Persona;
import org.glassfish.jersey.model.ContractProvider;


@Path("/xmlServices")
public class PersonaWs {
	
	@GET
	@Path("/persona/{numeroDocumento}")
	@Produces(MediaType.APPLICATION_XML)
	public Persona getPersona(@PathParam("numeroDocumento") String numeroDocumento) {
		CuentaDao cuentaDao = new CuentaDao();
		Persona per = cuentaDao.getPersona(numeroDocumento);
		System.out.println("Persona Id"+per.getIdPersona());
		return per;
	}
}
