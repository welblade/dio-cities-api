package com.github.welblade.diocitiesapi.states;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "estado")
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class State {
    @Id
    private int id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private String fu;

    private int ibge;

    @Column(name = "pais")
    private Integer countryId;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd")
    private List<Integer> areaCode;

    State() {
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

    public  Integer getCountryId() {
        return countryId;
    }

    public int getIbge() {
        return ibge;
    }

    public List<Integer> getAreaCode() {
        return areaCode;
    }
}
