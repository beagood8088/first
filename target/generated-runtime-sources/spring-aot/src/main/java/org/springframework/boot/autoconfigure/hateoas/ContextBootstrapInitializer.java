package org.springframework.boot.autoconfigure.hateoas;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.hateoas.mediatype.hal.HalConfiguration;

public final class ContextBootstrapInitializer {
  public static void registerHypermediaAutoConfiguration_applicationJsonHalConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("applicationJsonHalConfiguration", HalConfiguration.class).withFactoryMethod(HypermediaAutoConfiguration.class, "applicationJsonHalConfiguration")
        .instanceSupplier(() -> beanFactory.getBean(HypermediaAutoConfiguration.class).applicationJsonHalConfiguration()).register(beanFactory);
  }
}
