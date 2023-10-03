package com.kadikoy.mockemulator.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppRunConfig implements CommandLineRunner {

  private final WireMockServer wireMockServer;

  @Override
  public void run(String... args) {
    wireMockServer.start();
  }
}
