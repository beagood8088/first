package org.springframework.data.rest.webmvc.config;

import java.util.Optional;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryResourceMappings;
import org.springframework.data.rest.core.support.SelfLinkProvider;
import org.springframework.data.rest.webmvc.mapping.Associations;
import org.springframework.data.rest.webmvc.mapping.LinkCollector;
import org.springframework.hateoas.server.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;

public final class FirstApplicationTestsContextInitializer {
  public static void registerRepositoryRestMvcConfiguration_halFormsJacksonHttpMessageConverter(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("halFormsJacksonHttpMessageConverter", TypeConstrainedMappingJackson2HttpMessageConverter.class).withFactoryMethod(RepositoryRestMvcConfiguration.class, "halFormsJacksonHttpMessageConverter", LinkCollector.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RepositoryRestMvcConfiguration.class).halFormsJacksonHttpMessageConverter(attributes.get(0)))).register(beanFactory);
  }

  public static void registerRepositoryRestMvcConfiguration_restHandlerMapping(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("restHandlerMapping", DelegatingHandlerMapping.class).withFactoryMethod(RepositoryRestMvcConfiguration.class, "restHandlerMapping", Repositories.class, RepositoryResourceMappings.class, Optional.class, RepositoryRestConfiguration.class, CorsConfigurationAware.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RepositoryRestMvcConfiguration.class).restHandlerMapping(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4)))).register(beanFactory);
  }

  public static void registerRepositoryRestMvcConfiguration_linkCollector(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("linkCollector", LinkCollector.class).withFactoryMethod(RepositoryRestMvcConfiguration.class, "linkCollector", PersistentEntities.class, SelfLinkProvider.class, Associations.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RepositoryRestMvcConfiguration.class).linkCollector(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }
}
