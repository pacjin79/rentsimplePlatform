import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.PlatformConfig;
import controllers.platform.FeatureToggleController;
import play.Application;
import play.GlobalSettings;
import play.Logger;

public class Global extends GlobalSettings {
	private ApplicationContext ctx;

	static class InitialData {

		public static void insert(Application app) {

		}
	}

	public void onStart(Application app) {
		Logger.info("Application has started");
		//ctx = new AnnotationConfigApplicationContext(PlatformConfig.class);
		ctx = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/*-beans.xml");
		// FeatureToggleController fController = (FeatureToggleController)
		// ctx.getBean("platformFeatureToggleController");
		String[] beanNames = ctx.getBeanDefinitionNames();
		if (beanNames == null || beanNames.length == 0) {
			System.out.println("+++++No beans found what's so ever **!  ");
		} else {
			for (String bn : beanNames) {
				System.out.println("++++++bean name = " + bn + " really, this is shit only 1 hope it loads?");
			}
		}
		//PlatformConfig pConfig = (PlatformConfig) ctx.getBean("platformConfig");
		//String test = "";
		//test = "";
	}

	public void onStop(Application app) {
		Logger.info("Application shutdown...");
	}

	@Override
	public <A> A getControllerInstance(Class<A> clazz) {
		// if (clazz.isAnnotationPresent(Component.class) ||
		// clazz.isAnnotationPresent(Controller.class) ||
		// clazz.isAnnotationPresent(Service.class)
		// || clazz.isAnnotationPresent(Repository.class))
		try {
			System.out.println("Gottdim class = "+clazz.getCanonicalName());
			return ctx.getBean(clazz);
		} catch (NoSuchBeanDefinitionException e) {
			System.out.println("oh no - no bean found!");
			return null;
		}
		// else
		// return null;
	}
}
