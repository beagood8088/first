package org.springframework.boot.autoconfigure.data.rest;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class FirstApplicationTestsContextInitializer {
  public static void registerRepositoryRestMvcAutoConfiguration_springBootRepositoryRestConfigurer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("springBootRepositoryRestConfigurer", SpringBootRepositoryRestConfigurer.class).withFactoryMethod(RepositoryRestMvcAutoConfiguration.class, "springBootRepositoryRestConfigurer", ObjectProvider.class, RepositoryRestProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RepositoryRestMvcAutoConfiguration.class).springBootRepositoryRestConfigurer(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }
}
