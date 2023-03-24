package com.clases.usuario

class DetalleDeVenta {

    boolean activo=true

    static belongsTo = [venta:Venta]

    Servicios servicios

    Mascota mascota

    Float subtotal

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'detalle_seq']
    }
}
