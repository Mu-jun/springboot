package mjspring.springboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringbootApplication {

	public static void main(String[] args) {
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		applicationContext.registerBean(HelloController.class); // Bean 등록
		applicationContext.registerBean(SimpleHelloService.class); // 생성 순서와 DI는 스프링이 알아서 구현체 정보를 가지고 결정함.
		applicationContext.refresh(); // 초기화(재구성?)

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("frontcontroller",
					new DispatcherServlet(applicationContext)
				).addMapping("/*");
		});
		webServer.start();
	}

}
