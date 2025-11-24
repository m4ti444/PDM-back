package com.example.pdm_back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "auto")
@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "modeloAuto", length = 50, nullable = false)
    private String modelo;

    @Column(name = "marcaAuto", length = 50, nullable = false)
    private String marca;

    @Column(name = "combustibleAuto", length = 50, nullable = false)
    private String combustible;

    @Column(name = "origenAuto", length = 50, nullable = false)
    private String origen;

    @Column(name = "colorAuto", length = 50, nullable = false)
    private String color;

    @Column(name = "urlAuto", nullable = false)
    private String url;

    @Column(name = "precioAuto")
    private Integer precio;

    @Column(name = "velocidadAuto")
    private String velocidad;

    @Column(name = "rangoAuto")
    private String rango;

    @Column(name = "descripcionAuto", length = 500)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipo_auto_id", nullable = false)
    private TipoAuto tipoAuto;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = true)
    private Venta venta;
}
