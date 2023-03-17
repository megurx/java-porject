package ru.kubsu.geocoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kubsu.geocoder.client.NominatimClient;
import ru.kubsu.geocoder.dto.NominatimPlace;
import ru.kubsu.geocoder.dto.RestApiError;
import ru.kubsu.geocoder.model.Test;
import ru.kubsu.geocoder.service.TestService;

import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("tests")
public class TestController {
  private TestService service;
  private NominatimClient nominatimClient;

  @Autowired
  public TestController(TestService service, NominatimClient nominatimClient) {
    this.nominatimClient = nominatimClient;
    this.service = service;
  }


  // /tests/1?name=test
  @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Test getTest(@PathVariable Integer id,
                      @RequestParam String name) {
    return service.build(id, name);
  }

  // /tests/save?name=test
  @GetMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
  public void save(@RequestParam String name) {
    service.save(name);
  }

  // tests/load/test
  @GetMapping(value = "/load/{name}", produces = APPLICATION_JSON_VALUE)
  public Test load(@PathVariable String name) {
    return service.load(name);
  }

  @GetMapping(value = "/search", produces = APPLICATION_JSON_VALUE)
  public String search() {
    return nominatimClient.search("кубгу", "json").get(0).getType();
  }

  @GetMapping(value = "/reverse", produces = APPLICATION_JSON_VALUE)
  public NominatimPlace reverse() {
    return nominatimClient.reverse(45.046580, 38.978289,"json");
  }

  @GetMapping(value = "/status1", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> hello() {
    Random random = new Random();
    if (random.nextDouble() > 0.5) {
      NominatimPlace place = new NominatimPlace();
      return
        ResponseEntity
          .status(HttpStatus.OK)
          .body("qw");

    } else {
      NominatimPlace place = new NominatimPlace();
      RestApiError error = new RestApiError();
      return
        ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("qw");
    }
  }
}

