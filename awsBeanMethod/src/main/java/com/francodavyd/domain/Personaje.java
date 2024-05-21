package com.francodavyd.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personaje {
    private Long id;
    private String nombre;
    private String habilidad;
    private int vida;
}
