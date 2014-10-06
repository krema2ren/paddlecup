package dk.jdma.paddlecup;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareBean implements AuditorAware<String> {
    public String getCurrentAuditor() {
//        return SecurityContextHolder.getContext().getAuthentication().getName();
        return "TestProfile";
    }
}
