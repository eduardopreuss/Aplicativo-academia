package ifrs.pw2.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jettison.JettisonFeature;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new java.util.HashSet<>();
        singletons.add(new JettisonFeature());
        return singletons;
    }
    
    @Override
    public Map<String, Object> getProperties(){
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.server.provider.packages", "ifrs.pw2");
        return properties;
    }

    
}
