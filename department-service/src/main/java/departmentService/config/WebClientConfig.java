package departmentService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import departmentService.client.EmployeeClient;

@Configuration
public class WebClientConfig {
	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;
	@Bean
	WebClient getWebClient() {
		return WebClient.builder()
				.baseUrl("http://swaraj-employee-service")
				.filter(filterFunction)
				.build();
	}
	
	@Bean
	EmployeeClient getEmployeeClient() {
		HttpServiceProxyFactory httpServiceProxyFactory=HttpServiceProxyFactory
				.builderFor(WebClientAdapter.create(getWebClient()))
				.build();
		return httpServiceProxyFactory.createClient(EmployeeClient.class);
		
	}
}
