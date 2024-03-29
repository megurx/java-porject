package ru.kubsu.geocoder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kubsu.geocoder.client.NominatimClient;
import ru.kubsu.geocoder.model.Address;
import ru.kubsu.geocoder.repository.AddressRepository;

import java.util.Optional;

/**
 * Javadoc.
 */
@Service
public class AddressService {

  private final NominatimClient nominatimClient;
  private final AddressRepository addressRepository;

  @Autowired
  public AddressService(final NominatimClient nominatimClient,
                        final AddressRepository addressRepository) {
    this.nominatimClient = nominatimClient;
    this.addressRepository = addressRepository;
  }

  //  public Optional<Address> search(final String address) {
  //    final Optional<Address> cacheValue = addressRepository.findByAddress(address);
  //    if (cacheValue.isPresent()) {
  //      return cacheValue;
  //    }
  //
  //    final Optional<NominatimPlace> nominatimValue = nominatimClient.search(address);
  //    if (nominatimValue.isPresent()) {
  //      return Optional.of(Address.of(nominatimValue.get()));
  //    }
  //    return Optional.empty();
  //  }
  public Optional<Address> search(final String query) {
    return addressRepository.findByQuery(query)
      .or(() -> nominatimClient.search(query)
        .map(p -> addressRepository.save(Address.of(p, query))));
  }

  public Optional<Address> reverse(final Double lat, final Double lon) {
    return addressRepository.findByLatitudeAndLongitude(lat, lon)
      .or(() -> nominatimClient.reverse(lat, lon)
        .map(p -> addressRepository.save(Address.like(p, "", lat, lon)))
        );
  }
}
  //  public Optional<Address> search(final String address) {
  //    return addressRepository.findByAddress(address)
  //      .or(() ->{
  //        final Optional<Address>value = nominatimClient.search(address)
  //          .map(p->{
  //            final Address value1 = Address.of(p);
  //            addressRepository.save(value1;
  //            return value1;
  //
  //    });
  //            return value;
  //      });
