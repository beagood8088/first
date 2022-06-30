package org.springframework.hateoas.config;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.core.AnnotationLinkRelationProvider;
import org.springframework.hateoas.server.core.ControllerEntityLinksFactoryBean;
import org.springframework.hateoas.server.core.DelegatingEntityLinks;
import org.springframework.hateoas.server.core.DelegatingLinkRelationProvider;
import org.springframework.hateoas.server.mvc.RepresentationModelProcessorInvoker;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilderFactory;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.util.ReflectionUtils;

public final class FirstApplicationTestsContextInitializer {
  public static void registerWebTestHateoasConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.hateoas.config.WebTestHateoasConfiguration", WebTestHateoasConfiguration.class)
        .instanceSupplier(WebTestHateoasConfiguration::new).register(beanFactory);
  }

  public static void registerWebTestHateoasConfiguration_webTestClientConfigurer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("webTestClientConfigurer", HypermediaWebTestClientConfigurer.class).withFactoryMethod(WebTestHateoasConfiguration.class, "webTestClientConfigurer", ObjectProvider.class, List.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebTestHateoasConfiguration.class).webTestClientConfigurer(attributes.get(0), attributes.get(1)))).customize((bd) -> bd.setLazyInit(true)).register(beanFactory);
  }

  public static void registerHateoasConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.hateoas.config.HateoasConfiguration", HateoasConfiguration.class)
        .instanceSupplier((instanceContext) -> {
          HateoasConfiguration bean = new HateoasConfiguration();
          instanceContext.field("context", ApplicationContext.class)
              .invoke(beanFactory, (attributes) -> {
                Field contextField = ReflectionUtils.findField(HateoasConfiguration.class, "context", ApplicationContext.class);
                ReflectionUtils.makeAccessible(contextField);
                ReflectionUtils.setField(contextField, bean, attributes.get(0));
              });
              return bean;
            }).register(beanFactory);
      }

      public static void registerHateoasConfiguration_hypermediaWebMvcConverters(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("hypermediaWebMvcConverters", WebConverters.class).withFactoryMethod(HateoasConfiguration.class, "hypermediaWebMvcConverters", ObjectProvider.class, List.class, Optional.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HateoasConfiguration.class).hypermediaWebMvcConverters(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
      }

      public static void registerHateoasConfiguration_defaultRelProvider(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("defaultRelProvider", LinkRelationProvider.class).withFactoryMethod(HateoasConfiguration.class, "defaultRelProvider")
            .instanceSupplier(() -> beanFactory.getBean(HateoasConfiguration.class).defaultRelProvider()).register(beanFactory);
      }

      public static void registerHateoasConfiguration_annotationRelProvider(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("annotationRelProvider", AnnotationLinkRelationProvider.class).withFactoryMethod(HateoasConfiguration.class, "annotationRelProvider")
            .instanceSupplier(() -> beanFactory.getBean(HateoasConfiguration.class).annotationRelProvider()).register(beanFactory);
      }

      public static void registerHateoasConfiguration__relProvider(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("_relProvider", DelegatingLinkRelationProvider.class).withFactoryMethod(HateoasConfiguration.class, "_relProvider", PluginRegistry.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HateoasConfiguration.class)._relProvider(attributes.get(0)))).customize((bd) -> bd.setPrimary(true)).register(beanFactory);
      }

      public static void registerHateoasConfiguration_relProviderPluginRegistry(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("relProviderPluginRegistry", ResolvableType.forClassWithGenerics(PluginRegistry.class, LinkRelationProvider.class, LinkRelationProvider.LookupContext.class)).withFactoryMethod(HateoasConfiguration.class, "relProviderPluginRegistry")
            .instanceSupplier(() -> beanFactory.getBean(HateoasConfiguration.class).relProviderPluginRegistry()).register(beanFactory);
      }

      public static void registerHateoasConfiguration_linkDiscoverers(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("linkDiscoverers", LinkDiscoverers.class).withFactoryMethod(HateoasConfiguration.class, "linkDiscoverers", PluginRegistry.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HateoasConfiguration.class).linkDiscoverers(attributes.get(0)))).register(beanFactory);
      }

      public static void registerWebMvcEntityLinksConfiguration(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("org.springframework.hateoas.config.WebMvcEntityLinksConfiguration", WebMvcEntityLinksConfiguration.class)
            .instanceSupplier(WebMvcEntityLinksConfiguration::new).register(beanFactory);
      }

      public static void registerWebMvcEntityLinksConfiguration_webMvcEntityLinks(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("webMvcEntityLinks", ControllerEntityLinksFactoryBean.class).withFactoryMethod(WebMvcEntityLinksConfiguration.class, "webMvcEntityLinks", ObjectProvider.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcEntityLinksConfiguration.class).webMvcEntityLinks(attributes.get(0)))).register(beanFactory);
      }

      public static void registerEntityLinksConfiguration_entityLinksPluginRegistry(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("entityLinksPluginRegistry", PluginRegistry.class).withFactoryMethod(EntityLinksConfiguration.class, "entityLinksPluginRegistry")
            .instanceSupplier(() -> beanFactory.getBean(EntityLinksConfiguration.class).entityLinksPluginRegistry()).register(beanFactory);
      }

      public static void registerEntityLinksConfiguration_delegatingEntityLinks(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("delegatingEntityLinks", DelegatingEntityLinks.class).withFactoryMethod(EntityLinksConfiguration.class, "delegatingEntityLinks", PluginRegistry.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(EntityLinksConfiguration.class).delegatingEntityLinks(attributes.get(0)))).customize((bd) -> bd.setPrimary(true)).register(beanFactory);
      }

      public static void registerWebMvcHateoasConfiguration(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("org.springframework.hateoas.config.WebMvcHateoasConfiguration", WebMvcHateoasConfiguration.class)
            .instanceSupplier(WebMvcHateoasConfiguration::new).register(beanFactory);
      }

      public static void registerWebMvcHateoasConfiguration_hypermediaWebMvcConfigurer(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("hypermediaWebMvcConfigurer", WebMvcHateoasConfiguration.HypermediaWebMvcConfigurer.class).withFactoryMethod(WebMvcHateoasConfiguration.class, "hypermediaWebMvcConfigurer", WebConverters.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcHateoasConfiguration.class).hypermediaWebMvcConfigurer(attributes.get(0)))).register(beanFactory);
      }

      public static void registerWebMvcHateoasConfiguration_representationModelProcessorInvoker(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("representationModelProcessorInvoker", RepresentationModelProcessorInvoker.class).withFactoryMethod(WebMvcHateoasConfiguration.class, "representationModelProcessorInvoker", List.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcHateoasConfiguration.class).representationModelProcessorInvoker(attributes.get(0)))).register(beanFactory);
      }

      public static void registerWebMvcHateoasConfiguration_hypermediaRepresentionModelProcessorConfigurator(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("hypermediaRepresentionModelProcessorConfigurator", WebMvcHateoasConfiguration.HypermediaRepresentationModelBeanProcessorPostProcessor.class).withFactoryMethod(WebMvcHateoasConfiguration.class, "hypermediaRepresentionModelProcessorConfigurator", ObjectProvider.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> WebMvcHateoasConfiguration.hypermediaRepresentionModelProcessorConfigurator(attributes.get(0)))).register(beanFactory);
      }

      public static void registerWebMvcHateoasConfiguration_webMvcLinkBuilderFactory(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("webMvcLinkBuilderFactory", WebMvcLinkBuilderFactory.class).withFactoryMethod(WebMvcHateoasConfiguration.class, "webMvcLinkBuilderFactory", ObjectProvider.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcHateoasConfiguration.class).webMvcLinkBuilderFactory(attributes.get(0)))).register(beanFactory);
      }

      public static void registerRestTemplateHateoasConfiguration(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("org.springframework.hateoas.config.RestTemplateHateoasConfiguration", RestTemplateHateoasConfiguration.class)
            .instanceSupplier(RestTemplateHateoasConfiguration::new).register(beanFactory);
      }

      public static void registerRestTemplateHateoasConfiguration_hypermediaRestTemplateBeanPostProcessor(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("hypermediaRestTemplateBeanPostProcessor", RestTemplateHateoasConfiguration.HypermediaRestTemplateBeanPostProcessor.class).withFactoryMethod(RestTemplateHateoasConfiguration.class, "hypermediaRestTemplateBeanPostProcessor", ObjectFactory.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> RestTemplateHateoasConfiguration.hypermediaRestTemplateBeanPostProcessor(attributes.get(0)))).register(beanFactory);
      }

      public static void registerRestTemplateHateoasConfiguration_hypermediaRestTemplateConfigurer(
          DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("hypermediaRestTemplateConfigurer", HypermediaRestTemplateConfigurer.class).withFactoryMethod(RestTemplateHateoasConfiguration.class, "hypermediaRestTemplateConfigurer", WebConverters.class)
            .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestTemplateHateoasConfiguration.class).hypermediaRestTemplateConfigurer(attributes.get(0)))).customize((bd) -> bd.setLazyInit(true)).register(beanFactory);
      }
    }
