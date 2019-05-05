package in.nvijaykarthik.exec.arround;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Resource {

	
	private static final Logger log = LoggerFactory.getLogger(Resource.class);

	@Autowired
	SecuredServiceCaller<String> caller;

	@RequestMapping("/getName1")
	public String getName() {

		// no need to write boiler plate code to call the IDM and get the new token and process the service. this is done by execute arround pattern ie., SecuredServiceCaller
		
		String resp=caller.callService(new SecuredServiceHandler<String>() {
			@Override
			public String execute(RestTemplate rt, HttpEntity<String> entity) {
				ResponseEntity<String> response = rt.exchange("http://localhost:8080/api/caller1", HttpMethod.GET, entity,
						String.class);
				return response.getBody();
			}
		});
		
		log.info(resp);
		return resp;
	}
	
	@RequestMapping("/getName2")
	public String getName2() {

		// no need to write boiler plate code to call the IDM and get the new token and process the service. this is done by execute arround pattern ie., SecuredServiceCaller
		
		String resp=caller.callService(new SecuredServiceHandler<String>() {
			@Override
			public String execute(RestTemplate rt, HttpEntity<String> entity) {
				ResponseEntity<String> response = rt.exchange("http://localhost:8080/api/caller2", HttpMethod.GET, entity,
						String.class);
				return response.getBody();
			}
		});
		
		log.info(resp);
		return resp;
	}
}
