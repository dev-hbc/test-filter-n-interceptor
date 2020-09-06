package demo.InterceptorimplbyExtendedHandlerInterceptorAdapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:spring-beans.xml"})
public class InterceptorImplByExtendedHandlerInterceptorAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterceptorImplByExtendedHandlerInterceptorAdapterApplication.class, args);
	}

}
