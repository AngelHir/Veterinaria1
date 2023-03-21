package com.clases.usuario

class Usuario {

    static belongsTo = [cliente: Cliente]

    String nombre

    String contrasena

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'usuario_seq']
    }
}
