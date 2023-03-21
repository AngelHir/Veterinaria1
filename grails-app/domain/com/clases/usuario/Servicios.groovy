package com.clases.usuario

class Servicios {

    Cliente cliente

    String nombre

    String descripcion

    float precio

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'servicios_seq']
    }
}
