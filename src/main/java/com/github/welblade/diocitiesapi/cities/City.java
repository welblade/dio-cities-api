package com.github.welblade.diocitiesapi.cities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class City {
    @Id
    private int id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private String fu;

    private int ibge;

    @Column(name = "lat_lon")
    private String coordinate;

    private Double latitude;

    private Double longitude;

    @Column(name = "cod_tom")
    private int codTom;

    City() {
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getFu() {
        return fu;
    }

    int getIbge() {
        return ibge;
    }

    String getCoordinate() {
        return coordinate;
    }

    double getLatitude() {
        return latitude;
    }

    double getLongitude() {
        return longitude;
    }

    int getCodTom() {
        return codTom;
    }
}