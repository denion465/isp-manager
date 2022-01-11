package com.ispmanager.backend.security;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
  private final Environment env;

  AppProperties(Environment env) {
    this.env = env;
  }

  public String getTokenSecret() {
    return env.getProperty("tokenSecret");
  }
}
