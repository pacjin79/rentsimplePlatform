package platform.services.togglz;

import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.spi.FeatureManagerProvider;

public abstract class AbstractFeatureManagerProvider implements FeatureManagerProvider {

	private static FeatureManager featureManager;

	private static TogglzConfig togglzConfig;


	@Override
	public int priority() {
		return 30;
	}

	@Override
	public synchronized FeatureManager getFeatureManager() {
		if(togglzConfig == null){
			togglzConfig = getTogglzConfig();
		}
		if (featureManager == null) {
			featureManager = new FeatureManagerBuilder().featureEnum(togglzConfig.getFeatureClass())
					.stateRepository(togglzConfig.getStateRepository()).userProvider(togglzConfig.getUserProvider()).build();
		}
		return featureManager;
	}
	
	protected abstract TogglzConfig getTogglzConfig();
}
