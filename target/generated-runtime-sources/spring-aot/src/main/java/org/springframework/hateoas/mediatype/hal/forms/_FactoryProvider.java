package org.springframework.hateoas.mediatype.hal.forms;

public abstract class _FactoryProvider {
  public static HalFormsAffordanceModelFactory halFormsAffordanceModelFactory() {
    return new HalFormsAffordanceModelFactory();
  }

  public static HalFormsMediaTypeConfigurationProvider halFormsMediaTypeConfigurationProvider() {
    return new HalFormsMediaTypeConfigurationProvider();
  }
}
