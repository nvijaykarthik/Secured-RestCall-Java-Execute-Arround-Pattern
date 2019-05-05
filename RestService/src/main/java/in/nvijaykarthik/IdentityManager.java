package in.nvijaykarthik;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identityManager")
public class IdentityManager {

	
	// sample mock methos that give a OTT for the given user,pass. 
	// this is just for simuation should not be used in production
	@GetMapping("/token")
	public String getToken(@RequestParam String username, @RequestParam String password) {
		return UUID.randomUUID().toString();
	}
}
