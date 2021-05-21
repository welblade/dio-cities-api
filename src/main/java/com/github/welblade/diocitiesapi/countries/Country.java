package com.github.welblade.diocitiesapi.countries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Country {
    @Id
    private long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String portugueseName;

    @Column(name = "sigla")
    private String abbr;
    
    private int bacen;

    Country(){

    }

    long getId() {
        return id;
    }

    String getName() {
        return name;
    }
    
    String getPortugueseName() {
        return portugueseName;
    }

    String getAbbr() {
        return abbr;
    }

    int getBacen() {
        return bacen;
    }

    
}
