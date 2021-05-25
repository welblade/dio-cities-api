package com.github.welblade.diocitiesapi.cities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "cidade")
public class City extends RepresentationModel<City>{
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFu() {
        return fu;
    }

    public int getIbge() {
        return ibge;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getCodTom() {
        return codTom;
    }
}