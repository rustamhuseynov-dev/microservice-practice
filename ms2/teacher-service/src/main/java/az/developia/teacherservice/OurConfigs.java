package az.developia.teacherservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OurConfigs {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplate r=new RestTemplate();
		return r;
	}
	
}
