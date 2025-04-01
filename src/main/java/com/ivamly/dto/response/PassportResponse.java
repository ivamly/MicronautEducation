package com.ivamly.dto.response;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PassportResponse {

    /**
     * Identifier.
     */
    private String id;

    /**
     * Passport series.
     */
    private String series;

    /**
     * Passport number.
     */
    private String number;

    /**
     * Address information {@link AddressResponse}.
     */
    private AddressResponse address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }
}
