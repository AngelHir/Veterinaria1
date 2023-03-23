package com.clases.usuario

class DetalleDeVenta {

    boolean activo=true


    Venta venta

    Date fecha

    Float subtotal

    Float total

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'detalle_seq']
    }
}
