package com.kadikoy.mockemulator.config;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WireMockConfig {
  @Bean
  public WireMockServer wireMockServer(WireMockProperties config) {
    final WireMockConfiguration wireMockConfiguration = WireMockConfiguration
        .options()
        .notifier(new ConsoleNotifier(config.isVerbose()))
        .usingFilesUnderClasspath(config.getFileSourcePath())
        .containerThreads(defaultIfNull(config.getContainerThreads(), 50))
        .port(config.getPort())
        .asynchronousResponseEnabled(config.isAsynchronousResponseEnabled())
        .asynchronousResponseThreads(config.getAsynchronousResponseThreads())
        .jettyAcceptors(config.getJettyAcceptors());

    if (config.isDisableRequestJournal()) {
      wireMockConfiguration.disableRequestJournal();
    }
    return new WireMockServer(wireMockConfiguration);
  }
}
