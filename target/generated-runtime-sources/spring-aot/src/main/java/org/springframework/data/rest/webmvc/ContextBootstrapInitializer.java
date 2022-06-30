package org.springframework.data.rest.webmvc;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.repository.support.RepositoryInvokerFactory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryResourceMappings;
import org.springframework.data.rest.webmvc.alps.AlpsController;
import org.springframework.data.rest.webmvc.json.PersistentEntityToJsonSchemaConverter;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.server.EntityLinks;

public final class ContextBootstrapInitializer {
  public static void registerRestControllerConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.data.rest.webmvc.RestControllerConfiguration", RestControllerConfiguration.class).withConstructor(RepositoryRestConfiguration.class, RepositoryResourceMappings.class, PagedResourcesAssembler.class, Repositories.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new RestControllerConfiguration(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3)))).register(beanFactory);
  }

  public static void registerRestControllerConfiguration_repositoryController(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("repositoryController", RepositoryController.class).withFactoryMethod(RestControllerConfiguration.class, "repositoryController", EntityLinks.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestControllerConfiguration.class).repositoryController(attributes.get(0)))).register(beanFactory);
  }

  public static void registerRestControllerConfiguration_repositoryEntityController(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("repositoryEntityController", RepositoryEntityController.class).withFactoryMethod(RestControllerConfiguration.class, "repositoryEntityController", RepositoryEntityLinks.class, HttpHeadersPreparer.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestControllerConfiguration.class).repositoryEntityController(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerRestControllerConfiguration_repositoryPropertyReferenceController(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("repositoryPropertyReferenceController", RepositoryPropertyReferenceController.class).withFactoryMethod(RestControllerConfiguration.class, "repositoryPropertyReferenceController", RepositoryInvokerFactory.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestControllerConfiguration.class).repositoryPropertyReferenceController(attributes.get(0)))).register(beanFactory);
  }

  public static void registerRestControllerConfiguration_repositorySearchController(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("repositorySearchController", RepositorySearchController.class).withFactoryMethod(RestControllerConfiguration.class, "repositorySearchController", RepositoryEntityLinks.class, HttpHeadersPreparer.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestControllerConfiguration.class).repositorySearchController(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerRestControllerConfiguration_repositorySchemaController(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("repositorySchemaController", RepositorySchemaController.class).withFactoryMethod(RestControllerConfiguration.class, "repositorySchemaController", PersistentEntityToJsonSchemaConverter.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestControllerConfiguration.class).repositorySchemaController(attributes.get(0)))).register(beanFactory);
  }

  public static void registerRestControllerConfiguration_alpsController(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("alpsController", AlpsController.class).withFactoryMethod(RestControllerConfiguration.class, "alpsController")
        .instanceSupplier(() -> beanFactory.getBean(RestControllerConfiguration.class).alpsController()).register(beanFactory);
  }

  public static void registerRestControllerConfiguration_profileController(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("profileController", ProfileController.class).withFactoryMethod(RestControllerConfiguration.class, "profileController")
        .instanceSupplier(() -> beanFactory.getBean(RestControllerConfiguration.class).profileController()).register(beanFactory);
  }
}
