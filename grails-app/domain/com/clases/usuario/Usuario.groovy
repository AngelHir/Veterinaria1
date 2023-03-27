package com.clases.usuario

class Usuario {

    boolean activo=true

    static belongsTo = [cliente:Cliente]

    String usuario

    String contrasena

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'usuario_seq']
    }
}
