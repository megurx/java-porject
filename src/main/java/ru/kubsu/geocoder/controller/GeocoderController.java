package ru.kubsu.geocoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kubsu.geocoder.model.Address;
import ru.kubsu.geocoder.service.AddressService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * javadoc.
 */
@RestController
@RequestMapping("geocoder")
public class GeocoderController {
  private final AddressService addressService;
  @Autowired
  public GeocoderController(final AddressService addressService) {
    this.addressService = addressService;
  }

  @GetMapping(value = "/search", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Address> search(final @RequestParam String query) {
    return addressService.search(query)
      .map(p -> ResponseEntity.status(HttpStatus.OK).body(p))
      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }
  @GetMapping(value = "/reverse/{lat}&{lon}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Address> reverse(@PathVariable final Double lat, @PathVariable final Double lon) {
    return addressService.reverse(lat, lon)
      .map(p -> ResponseEntity.status(HttpStatus.OK).body(p))
      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }
}
