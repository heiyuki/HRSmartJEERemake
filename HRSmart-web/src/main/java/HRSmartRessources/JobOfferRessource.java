/**
 * @author Khaled Romdhane
 *
 */
package HRSmartRessources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pi.HRSmart.interfaces.JobOfferServiceLocal;
import pi.HRSmart.persistence.JobOffer;

/**
 * @author Khaled Romdhane
 *
 */
@Path("job")
@RequestScoped
public class JobOfferRessource {

	@EJB(beanName="JobOfferService")
	JobOfferServiceLocal service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public JobOffer getFull(@PathParam("id")int id){
		
		return service.getFull(id);
	}
}
