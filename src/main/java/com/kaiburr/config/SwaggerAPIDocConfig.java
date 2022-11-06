// SwaggerAPIDocConfig.java

package com.kaiburr.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerAPIDocConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiKey apiKeys() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");

	}

	private List<SecurityContext> securityContexts() {
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}

	private List<SecurityReference> sf() {
		AuthorizationScope scopes = new AuthorizationScope("global", "accesseverything");
		return Arrays.asList(new SecurityReference("scope", new AuthorizationScope[] { scopes }));
	}

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(createAPIInfo()).securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apiKeys())).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();

	}

	// helper method
	private ApiInfo createAPIInfo() {
		Contact contact = new Contact("Krishna Kumar", "https://krishnakumaryadav.netlify.app/",
				"krishnakumarrfj1015@gmail.com");

		return new ApiInfo("Actor-API Doc1", "API Info Actor API", "5.7.RELEASE", "http://www.google.com/license",
				contact, "GNU Public", "http://www.gnu.license.com", Collections.emptyList());
	}

}
