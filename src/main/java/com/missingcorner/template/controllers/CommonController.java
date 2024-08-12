package com.missingcorner.template.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.missingcorner.template.components.ConfigComponent;

@RestController
public class CommonController {
  @Autowired
  private ConfigComponent cfgComponent;

  @GetMapping("/_info")
  public ResponseEntity<Map<String, String>> getServerInfo() {
    return ResponseEntity.ok(this.cfgComponent.infoForClientProperty());
  }
}
