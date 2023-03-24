package com.clases.usuario

class Cliente {

    static hasOne = [usuario: Usuario]

    static hasMany=[mascotas:Mascota]

    boolean activo=true

    String nombre

    String apellido

    String telefono

    String email

    String direccion

    static constraints = {
        nombre nullable: false, blank: false
        apellido nullable: false, blank: false
        telefono nullable: false, blank: false
        email nullable: false, blank: false
        direccion nullable: false, blank: false
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'cliente_seq']
    }
}
