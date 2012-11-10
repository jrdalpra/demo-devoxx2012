package devoxx.plugin.translator.de;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import devoxx.api.*;
import devoxx.core.fwk.Constants;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.environment.osgi.api.annotation.Publish;
import org.jboss.weld.environment.osgi.api.events.BundleContainerEvents;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

@Lang(Lang.Language.DE)
@Publish
@ApplicationScoped
public class TranslatorPluginDE implements Plugin {
    
    @Inject BundleContext context;
    
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
        Translate.setClientId(Constants.clientId);
        Translate.setClientSecret(Constants.clientSecret);
        try {
            String translatedText = Translate.execute(content, Language.GERMAN);
            return translatedText;
        } catch (Exception ex) {
            return "german";
        }
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

    @Override
    public Long bundleId() {
        return context.getBundle().getBundleId();
    }

    @Override
    public Bundle bundle() {
        return context.getBundle();
    }
    
    @Override
    public boolean modifyContent() {
        return true;
    }
    
}
