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

    @Column(name = "modelo_auto", length = 50, nullable = false)
    private String modelo;

    @Column(name = "marca_auto", length = 50, nullable = false)
    private String marca;

    @Column(name = "combustible_auto", length = 50, nullable = false)
    private String combustible;

    @Column(name = "origen_auto", length = 50, nullable = false)
    private String origen;

    @Column(name = "color_auto", length = 50, nullable = false)
    private String color;

    @Column(name = "url_auto", nullable = false)
    private String url;

    @Column(name = "precio_auto")
    private Integer precio;

    @Column(name = "velocidad_auto")
    private String velocidad;

    @Column(name = "rango_auto")
    private String rango;

    @Column(name = "descripcion_auto", length = 500)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipo_auto_id", nullable = false)
    private TipoAuto tipoAuto;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = true)
    private Venta venta;
}
