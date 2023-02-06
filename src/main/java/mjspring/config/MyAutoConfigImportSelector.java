package mjspring.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "mjspring.config.autoconfig.DispatcherServletConfig",
                "mjspring.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
