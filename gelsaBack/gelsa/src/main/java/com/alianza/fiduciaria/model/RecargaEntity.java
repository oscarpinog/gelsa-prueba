package com.alianza.fiduciaria.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "recarga")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RecargaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ID;
    private int cantidad;
    private double valor;
    private String operador;
    private String vendedor;

   }
