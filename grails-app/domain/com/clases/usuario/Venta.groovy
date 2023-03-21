package com.clases.usuario

class Venta {

    Cliente clientes

    Servicios servicio

    Date fecha

    Float total

    static constraints = {
    }

    static mapping = {
        id generator: 'sequence', params: [sequence_name: 'venta_seq']
    }
}
