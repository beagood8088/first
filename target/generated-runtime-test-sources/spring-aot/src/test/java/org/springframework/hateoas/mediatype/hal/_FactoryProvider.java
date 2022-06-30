package org.springframework.hateoas.mediatype.hal;

public abstract class _FactoryProvider {
  public static HalTraversonDefaults halTraversonDefaults() {
    return new HalTraversonDefaults();
  }

  public static HalMediaTypeConfigurationProvider halMediaTypeConfigurationProvider() {
    return new HalMediaTypeConfigurationProvider();
  }
}
