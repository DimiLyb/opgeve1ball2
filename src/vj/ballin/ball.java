package vj.ballin;

import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import redis.clients.jedis.Jedis;


@RequestScoped
@Path("/products")
public class ball {

	Random rand = new Random();
	String antwoord = new String();
	
	@Path("/{shortname}")
	@Produces({"text/html"})
	public String question(@PathParam("shortname") String quest) {
		
	
    Jedis jedis = new Jedis("localhost");
    antwoord = jedis.get(quest);
    if(antwoord == null)
    {
    	jedis.set(quest, jedis.get("val" + rand.nextInt(20)));
    }

    return jedis.get(quest);
	}
	
	
}
