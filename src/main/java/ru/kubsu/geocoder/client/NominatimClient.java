/**
 * Copyright 2023
 */

package ru.kubsu.geocoder.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kubsu.geocoder.dto.NominatimPlace;

import java.util.List;
import java.util.Optional;

/**
 * @author megurx
 */
@FeignClient(value = "nominatim", url = "https://nominatim.openstreetmap.org")
public interface NominatimClient {
  String JSON_FORMAT = "json";

  @RequestMapping(method = RequestMethod.GET, value = "/search", produces = "application/json")
  List<NominatimPlace> search(@RequestParam("q") String query,
                              @RequestParam("format") String format);

  default Optional<NominatimPlace> search(final String query) {
    try {
      return Optional.of(search(query, JSON_FORMAT).get(0));
    } catch (Exception ex) {
      return Optional.empty();
    }
  }
  @RequestMapping(method = RequestMethod.GET, value = "/reverse", produces = "application/json")
  NominatimPlace reverse(@RequestParam("lat") Double lat,
                         @RequestParam("lon") Double lon,
                         @RequestParam("format") String format);

  default Optional<NominatimPlace> reverse(final Double lat, final Double lon) {
    try {
      return Optional.of(reverse(lat, lon, JSON_FORMAT));
    } catch (Exception ex) {
      return Optional.empty();
    }
  }
}
