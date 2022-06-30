package org.springframework.boot.autoconfigure.data.jdbc;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerJdbcRepositoriesAutoConfiguration_SpringBootJdbcConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration$SpringBootJdbcConfiguration", JdbcRepositoriesAutoConfiguration.SpringBootJdbcConfiguration.class)
        .instanceSupplier(JdbcRepositoriesAutoConfiguration.SpringBootJdbcConfiguration::new).register(beanFactory);
  }

  public static void registerJdbcRepositoriesAutoConfiguration_JdbcRepositoriesConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration$JdbcRepositoriesConfiguration", JdbcRepositoriesAutoConfiguration.JdbcRepositoriesConfiguration.class)
        .instanceSupplier(JdbcRepositoriesAutoConfiguration.JdbcRepositoriesConfiguration::new).register(beanFactory);
  }
}
