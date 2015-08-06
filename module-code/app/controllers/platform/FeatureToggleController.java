package controllers.platform;

import static play.mvc.Controller.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.metadata.FeatureMetaData;
import org.togglz.core.spi.FeatureManagerProvider;

import play.*;
import play.mvc.*;
import views.html.platform.*;

@Controller
public class FeatureToggleController {

	@Autowired
	private ApplicationContext ctx;

	public Result isFeatureEnabled(String featureLabel) {
		
		Map <String, FeatureManagerProvider> fmProviders = ctx.getBeansOfType(FeatureManagerProvider.class);
		for(String providerName : fmProviders.keySet()){
			FeatureManagerProvider fmProvider = fmProviders.get(providerName);
			FeatureManager fm = fmProvider.getFeatureManager();
			for (Feature f : fm.getFeatures()) {
				FeatureMetaData fmd = fm.getMetaData(f);
				if (featureLabel.equals(fmd.getLabel())) {
					return ok(String.valueOf(fm.getFeatureState(f).isEnabled()));
				}
			}
		}
		return badRequest();
	}

}
