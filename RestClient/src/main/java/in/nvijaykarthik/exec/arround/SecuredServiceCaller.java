package in.nvijaykarthik.exec.arround;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SecuredServiceCaller<T> {
	
	@Value("${accessUrl}")
	String accessUrl;
	@Value("${username}")
	String username;
	@Value("${password}")
	String password;

	public T callService(SecuredServiceHandler<T> caller) {
		RestTemplate tokenRT= new RestTemplateBuilder().build();;
		String idmUrl=accessUrl.concat("?username=").concat(username).concat("&password=").concat(password);
		String token=tokenRT.getForObject(idmUrl, String.class);
		RestTemplate rt= new RestTemplateBuilder().build();
		HttpHeaders headers = new HttpHeaders();
		headers.add("token", token);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		T t = caller.execute(rt,entity);
		
		return t;
	}

	
}
