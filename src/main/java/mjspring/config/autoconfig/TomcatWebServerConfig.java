package mjspring.config.autoconfig;

import mjspring.config.ConditionalMyOnClass;
import mjspring.config.EnableMyConfigurationProperties;
import mjspring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
//@Conditional(TomcatWebServerConfig.TomcatCondition.class)
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {
//    @Value("${contextPath}") // propertySourcesPlaceholderConfigurer가 있어야 함.
//    String contextPath;
//
//    @Value("${port:8080}") // default 처리
//    int port;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

//        factory.setContextPath(env.getProperty("contextPath"));
//        factory.setContextPath(this.contextPath);
//        factory.setPort(port);
        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());

        return factory;
    }

//    static class TomcatCondition implements Condition {
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat",
//                    context.getClassLoader());
//        }
//    }
}
