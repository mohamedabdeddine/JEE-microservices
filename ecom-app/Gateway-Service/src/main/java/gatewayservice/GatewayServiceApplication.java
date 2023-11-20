package gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run( GatewayServiceApplication.class, args);
	}


 //Static Configuration

/*@Bean
RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()

				//*travail sans eureka*//*
				//.route(r -> r.path("/clients/**").uri("http://localhost:8081/"))
				//.route(r -> r.path("/produits/**").uri("http://localhost:8082/"))
				//.route(r->r.path("/factures/**").uri("http://localhost:8083/"))

				//*travail avec eureka*//*
				.route(r -> r.path("/clients/**").uri("lb://CLIENT-SERVICE"))
				.route(r -> r.path("/produits/**").uri("lb://PRODUIT-SERVICE"))
                .route(r->r.path("/factures/**").uri("lb://FACTURE-SERVICE"))

				.build();
	}*/
	// Dynamic Configuration
	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc , DiscoveryLocatorProperties rlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc,rlp);
	}
}
