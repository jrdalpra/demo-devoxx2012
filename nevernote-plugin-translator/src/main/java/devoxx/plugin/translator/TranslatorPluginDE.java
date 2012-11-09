package devoxx.plugin.translator;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import devoxx.api.*;
import javax.enterprise.event.Observes;
import org.jboss.weld.environment.osgi.api.annotation.Publish;
import org.jboss.weld.environment.osgi.api.events.BundleContainerEvents;

@Lang(Lang.Language.DE)
@Publish
@ApplicationScoped
public class TranslatorPluginDE implements Plugin {
    
    public String pluginId() {
        return "german-translator";
    }
    
    public String name() {
        return "German translator";
    }
    
    public String desc() {
        return "A german translator"; 
    }
    
    public String apply(String content) {
        String url = "https://www.googleapis.com/language/translate/v2?key=AIzaSyCbAOjY3ODiL1aB8kdXsEkcBJblX48fS5U&source=de&target=de&q=Hello%20world";
        return "german";
    }
    
    public Map<String, File> resources() {
        return Collections.emptyMap();
    }
    
    public void start(@Observes BundleContainerEvents.BundleContainerInitialized evt) {
        System.out.println("Yeah bro !!!");
    }
    

    @Override
    public String icon() {
        return "icon-comment";
    }
}
