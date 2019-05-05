package in.nvijaykarthik.exec.arround;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public interface SecuredServiceHandler<T> {

	public T execute(RestTemplate rt,HttpEntity<String> entity);
}
