package com.kadikoy.mockemulator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("wiremock.server")
@Configuration
@Data
public class WireMockProperties {

  private Integer port;
  private String fileSourcePath;
  private boolean verbose;
  private Integer containerThreads;
  private boolean disableRequestJournal;
  private Long cacheSize;
  private boolean asynchronousResponseEnabled;
  private Integer asynchronousResponseThreads;
  private Integer jettyAcceptors;
}
