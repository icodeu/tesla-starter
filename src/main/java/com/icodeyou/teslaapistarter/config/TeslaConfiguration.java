/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.icodeyou.teslaapistarter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.icodeyou.teslaapistarter.properties.TeslaProperties;
import com.icodeyou.teslaapistarter.service.TeslaService;

@Configuration
@EnableConfigurationProperties(TeslaProperties.class)
public class TeslaConfiguration {

    @Autowired
    private TeslaProperties teslaProperties;

    @Bean
    public TeslaService teslaService() {
        return new TeslaService(teslaProperties.getEmail(), teslaProperties.getPassword());
    }

}
