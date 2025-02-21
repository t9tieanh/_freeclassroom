package com.freeclassroom.freeclassroom.configuration;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;

@org.mapstruct.MapperConfig
public interface BaseMapperConfig {
    @InheritConfiguration
    @InheritInverseConfiguration
    void inheritMapping();
}

