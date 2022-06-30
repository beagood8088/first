package org.springframework.hateoas.mediatype.hal;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.hateoas.client.LinkDiscoverer;

public final class ContextBootstrapInitializer {
  public static void registerHalMediaTypeConfiguration_halLinkDisocoverer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("halLinkDisocoverer", LinkDiscoverer.class).withFactoryMethod(HalMediaTypeConfiguration.class, "halLinkDisocoverer")
        .instanceSupplier(() -> beanFactory.getBean(HalMediaTypeConfiguration.class).halLinkDisocoverer()).register(beanFactory);
  }
}
