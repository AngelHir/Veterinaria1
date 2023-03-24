package com.clases.usuario

class Venta {

    boolean activo=true

    static hasMany = [detalles:DetalleDeVenta]

    Cliente cliente

    Date fecha

    Float total

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'venta_seq']
    }
}
