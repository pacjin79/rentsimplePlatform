package rentsimplePlatform.controllers.platform;

import static org.junit.Assert.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.platform.FeatureToggleController;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.spi.FeatureManagerProvider;
import org.togglz.core.user.UserProvider;

import platform.services.togglz.AbstractFeatureManagerProvider;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are
 * interested in mocking a whole application, see the wiki for more details.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/spring/*-beans.xml")
public class FeatureToggleControllerTest {
	

	@Autowired
	private FeatureToggleController featureToggleController;

	@Autowired
	private ApplicationContext ctx;

	@Test
	public void testFeatureEnabled() {
		registerAFakeFeatureManagerProvider();
		featureToggleController.isFeatureEnabled("properties");
		assertThat(featureToggleController).isNotNull();
		assertThat(ctx).isNotNull();
	}

	private void registerAFakeFeatureManagerProvider() {
		//RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(FakeFeatureManagerProvider.class);
		//RootBeanDefinition r2BeanDefinition = new RootBeanDefinition(FakeFeatureManager2Provider.class);
		//((GenericApplicationContext)ctx).registerBeanDefinition("fakeFeatureManagerProvider", rootBeanDefinition);
		//((GenericApplicationContext)ctx).registerBeanDefinition("fakeFeatureManagerProvide2", r2BeanDefinition);
	}

}
