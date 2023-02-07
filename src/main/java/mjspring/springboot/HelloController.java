package mjspring.springboot;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements ApplicationContextAware {
    private final HelloService helloService;
    private ApplicationContext applicationContext;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name==null|| name.trim().length()==0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return name + " : " + helloService.countOf(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println(applicationContext);
        this.applicationContext = applicationContext;
    }
}
