package com.entronomia.aplicaciones.conversormonedas.modelo;

import com.google.gson.annotations.SerializedName;

public class Moneda {
    @SerializedName("USD")
    Double dolar;

    @SerializedName("CLP")
    Double pesoChile;

    @SerializedName("MXN")
    Double pesoMexico;

    @SerializedName("EUR")
    Double euro;

    @SerializedName("BRL")
    Double realBrasil;

    public Double getDolar() {
        return dolar;
    }

    public Double getPesoChile() {
        return pesoChile;
    }

    public Double getPesoMexico() {
        return pesoMexico;
    }

    public Double getEuro() {
        return euro;
    }

    public Double getRealBrasil() {
        return realBrasil;
    }
}
