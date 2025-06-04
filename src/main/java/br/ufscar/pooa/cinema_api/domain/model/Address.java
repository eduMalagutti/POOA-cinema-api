package br.ufscar.pooa.cinema_api.domain.model;

import java.util.Objects;

public class Address {
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String neighborhood;
	private String street;
	private String number;
	private String complement;

	public Address(String country, String state, String city, String zipCode, String neighborhood, String street, String number, String complement) {
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.neighborhood = neighborhood;
		this.street = street;
		this.number = number;
		this.complement = complement;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return Objects.equals(country, address.country) && Objects.equals(state, address.state) && Objects.equals(city, address.city) && Objects.equals(zipCode, address.zipCode) && Objects.equals(neighborhood, address.neighborhood) && Objects.equals(street, address.street) && Objects.equals(number, address.number) && Objects.equals(complement, address.complement);
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, state, city, zipCode, neighborhood, street, number, complement);
	}
}