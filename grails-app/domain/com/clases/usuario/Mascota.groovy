package com.clases.usuario

class Mascota {

    boolean activo=true

    static belongsTo = [cliente:Cliente]

    String nombre

    String raza

    float peso

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'mascota_seq']
    }
}
