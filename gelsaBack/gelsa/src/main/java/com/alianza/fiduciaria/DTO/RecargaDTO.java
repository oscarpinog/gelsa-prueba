package com.alianza.fiduciaria.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RecargaDTO {
    private String ID;
    private int cantidad;
    private double valor;
    private String operador;
    private String vendedor;

}
