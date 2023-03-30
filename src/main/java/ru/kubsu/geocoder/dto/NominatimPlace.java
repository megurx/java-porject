package ru.kubsu.geocoder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Адресс.
 *
 * @param lat широта
 * @param lon долгота
 * @param displayName имя
 * @param type тип
 */
public record NominatimPlace(
    @JsonProperty("lat")
    Double lat,
    @JsonProperty("lon")
    Double lon,
    @JsonProperty("display_name")
    String displayName,
    @JsonProperty("type")
    String type
) {
  public NominatimPlace() {
    this(0.0, 0.0, "", "");
  }
}
