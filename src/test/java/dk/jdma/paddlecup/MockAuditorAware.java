package dk.jdma.paddlecup;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class MockAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() { return "TEST"; }

}
