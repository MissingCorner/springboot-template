package com.missingcorner.template.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigComponent {
  @Autowired
  private Environment env;

  public Map<String, String> infoForClientProperty() {
    Map<String, String> res = new HashMap<>();
    // Expose some BE config for FE such-as Okta client id config
    res.put("name", this.env.getProperty("spring.application.name"));
    return res;
  }
}