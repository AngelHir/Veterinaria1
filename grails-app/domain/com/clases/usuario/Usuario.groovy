package com.clases.usuario

class Usuario {

    static belongsTo = [cliente: Cliente]

    boolean activo=true

    String usuario

    String contrasena

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'usuario_seq']
    }
}
