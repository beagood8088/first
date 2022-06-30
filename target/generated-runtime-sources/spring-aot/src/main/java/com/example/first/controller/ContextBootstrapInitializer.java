package com.example.first.controller;

import com.example.first.repository.NotificationToSupervisorRepository;
import com.example.first.utils.Utils;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

public final class ContextBootstrapInitializer {
  public static void registerNotificationToSupervisorController(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("notificationToSupervisorController", NotificationToSupervisorController.class)
        .instanceSupplier((instanceContext) -> {
          NotificationToSupervisorController bean = new NotificationToSupervisorController();
          instanceContext.field("notificationToSupervisorRepository", NotificationToSupervisorRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field notificationToSupervisorRepositoryField = ReflectionUtils.findField(NotificationToSupervisorController.class, "notificationToSupervisorRepository", NotificationToSupervisorRepository.class);
                ReflectionUtils.makeAccessible(notificationToSupervisorRepositoryField);
                ReflectionUtils.setField(notificationToSupervisorRepositoryField, bean, attributes.get(0));
              });
              instanceContext.field("restTemplate", RestTemplate.class)
                  .invoke(beanFactory, (attributes) -> bean.restTemplate = attributes.get(0));
                  instanceContext.field("utils", Utils.class)
                      .invoke(beanFactory, (attributes) -> bean.utils = attributes.get(0));
                      return bean;
                    }).register(beanFactory);
              }
            }
