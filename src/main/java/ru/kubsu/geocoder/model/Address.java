package ru.kubsu.geocoder.model;

import ru.kubsu.geocoder.dto.NominatimPlace;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * пам
 * парам
 * приветствую смотрящих
 */
@Entity
@SuppressWarnings("PMD.AvoidFieldNameMatchingTypeName")
public final class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String address;
  private Double latitude;
  private Double longitude;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    final Address that = (Address) obj;
    return //Objects.equals(this.id, that.id) &&
      Objects.equals(this.address, that.address) &&
      Objects.equals(this.latitude, that.latitude) &&
      Objects.equals(this.longitude, that.longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address, latitude, longitude);
  }

  @Override
  public String toString() {
    return "Address[" +
      "id=" + id + ", " +
      "address=" + address + ", " +
      "latitude=" + latitude + ", " +
      "longitude=" + longitude + ']';
  }
  public static Address of(final NominatimPlace place){
    Address result = new Address();
    result.setAddress(place.displayName());
    result.setLatitude(place.latitude());
    result.setLongitude(place.longitude());
    return result;
  }
}