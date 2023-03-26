package com.clases.usuario

import grails.gorm.transactions.Transactional

@Transactional
class VentaService {

    DetalleDeVentaService detalleDeVentaService
    ClienteService clienteService

    Venta get(long id) {
        return Venta.get(id)
    }


    def save(Venta ventaInstance) throws Exception {
        if (ventaInstance && ventaInstance.validate()) {
            ventaInstance.save(flush: true)
            return ventaInstance
        }
        throw new Exception("Errores :${ventaInstance.errors}")
    }


    def create(Map ventaMap) {
        try {
            Venta ventaInstance
            ventaInstance = new Venta()
            ventaInstance.cliente= clienteService.get(ventaMap.nombre.id)
            ventaInstance.fecha = ventaMap.cliente as Date
            ventaInstance.total= ventaMap.total as Float
            ventaInstance.folio=ventaInstance.folio
            this.save(ventaInstance)
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }


    def update(Map ventaMap){
        try {
            Venta ventaInstance
            ventaInstance = this.get(ventaMap.id as long)
            ventaInstance = new Venta()
            ventaInstance.fecha = ventaMap.cliente as Date
            ventaInstance.total= ventaMap.total as Float
            ventaInstance.folio=ventaInstance.folio
            ventaMap.detallesDeVenta.each {Map detalleDeVentaMap
                ->ventaInstance.addToDetalles(detalleDeVentaService.create(detalleDeVentaMap,ventaInstance))}
            this.save(ventaInstance)
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }

    def delete(long id){
        try {
            Venta ventaInstance = this.get(id)
            if (ventaInstance) {
                ventaInstance.activo= false
                this.save(ventaInstance)
                return ventaInstance.id
            } else {
                throw new Exception("No existe con el id " + id)
            }
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }
    }

}