package in.nvijaykarthik;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActualRestResource {

	@GetMapping("/caller1")
	public String callService(@RequestHeader(name = "token",required = false) String token) {
		if(null==token) {
			throw new IllegalArgumentException("Authorised token missing");
		}
		return "You accessed the secured resource 1 "+token;
	}
	
	@GetMapping("/caller2")
	public String callService2(@RequestHeader(name = "token",required = false) String token) {
		if(null==token) {
			throw new IllegalArgumentException("Authorised token missing");
		}
		return "You accessed the secured resource 2 "+token;
	}
}
