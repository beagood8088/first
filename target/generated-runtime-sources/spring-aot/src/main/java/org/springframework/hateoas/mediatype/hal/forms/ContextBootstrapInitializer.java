package org.springframework.hateoas.mediatype.hal.forms;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.hateoas.server.core.DelegatingLinkRelationProvider;

public final class ContextBootstrapInitializer {
  public static void registerHalFormsMediaTypeConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.hateoas.mediatype.hal.forms.HalFormsMediaTypeConfiguration", HalFormsMediaTypeConfiguration.class).withConstructor(DelegatingLinkRelationProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, MessageResolver.class, AbstractAutowireCapableBeanFactory.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new HalFormsMediaTypeConfiguration(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4), attributes.get(5)))).register(beanFactory);
  }

  public static void registerHalFormsMediaTypeConfiguration_halFormsLinkDiscoverer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("halFormsLinkDiscoverer", LinkDiscoverer.class).withFactoryMethod(HalFormsMediaTypeConfiguration.class, "halFormsLinkDiscoverer")
        .instanceSupplier(() -> beanFactory.getBean(HalFormsMediaTypeConfiguration.class).halFormsLinkDiscoverer()).register(beanFactory);
  }

  public static void registerHalFormsMediaTypeConfiguration_halFormsTemplatePropertyWriter(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("halFormsTemplatePropertyWriter", HalFormsTemplatePropertyWriter.class).withFactoryMethod(HalFormsMediaTypeConfiguration.class, "halFormsTemplatePropertyWriter")
        .instanceSupplier(() -> beanFactory.getBean(HalFormsMediaTypeConfiguration.class).halFormsTemplatePropertyWriter()).register(beanFactory);
  }
}
