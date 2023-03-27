package com.clases.usuario

class Cliente {

    static hasMany=[mascotas:Mascota]

    boolean activo=true

    Usuario usuario

    String nombre

    String apellido

    String telefono

    String email

    String direccion

    static constraints = {

    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'cliente_seq']
    }
}
