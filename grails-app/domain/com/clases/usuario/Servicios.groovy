package com.clases.usuario

class Servicios {

    boolean activo=true

    String nombre

    String descripcion

    float precio

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'servicios_seq']
    }
}
