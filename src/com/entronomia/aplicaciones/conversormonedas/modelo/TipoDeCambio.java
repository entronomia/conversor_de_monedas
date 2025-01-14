package com.entronomia.aplicaciones.conversormonedas.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TipoDeCambio {
    @SerializedName("time_last_update_utc")
    String fechaUltima;
    @SerializedName("time_next_update_utc")
    String fechaProxima;
    @SerializedName("conversion_rates")
    Moneda moneda;

    public String getFechaUltima() {
        return fechaUltima;
    }

    public String getFechaProxima() {
        return fechaProxima;
    }

    public Moneda getMoneda() {
        return moneda;
    }
}
