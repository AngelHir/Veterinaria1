package com.clases.usuario

import grails.gorm.transactions.Transactional

@Transactional
class DetalleDeVentaService {

    ServiciosService serviciosService

    MascotaService mascotaService

    DetalleDeVenta get(long id) {
        return DetalleDeVenta.get(id)
    }


    def save(DetalleDeVenta detalleDeVentaInstance) throws Exception {
        if (detalleDeVentaInstance && detalleDeVentaInstance.validate()) {
            detalleDeVentaInstance.save(flush: true)
            return detalleDeVentaInstance
        }
        throw new Exception("Errores :${detalleDeVentaInstance.errors}")
    }


    def create(Map detalleDeVentaMap, Venta ventaInstance) {
        try {
            DetalleDeVenta detalleDeVentaInstance
            detalleDeVentaInstance = new DetalleDeVenta()
            detalleDeVentaInstance.servicios = serviciosService.get(detalleDeVentaMap.servicio.id)
            detalleDeVentaInstance.mascota = mascotaService.get(detalleDeVentaMap.masacota.id)
            detalleDeVentaInstance.subtotal = detalleDeVentaMap.subtotal as float
            detalleDeVentaInstance.venta = ventaInstance
            return this.save(detalleDeVentaInstance)
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }


    def update(Map detalleDeVentaMap){
        try {
            DetalleDeVenta detalleDeVentaInstance
            detalleDeVentaInstance = this.get(detalleDeVentaMap.id as long)
            detalleDeVentaInstance.servicios = serviciosService.get(detalleDeVentaMap.servicio.id)
            detalleDeVentaInstance.mascota = mascotaService.get(detalleDeVentaMap.masacota.id)
            detalleDeVentaInstance.subtotal = detalleDeVentaMap.subtotal as float
            this.save(detalleDeVentaInstance)
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }

    def delete(long id){
        try {
            DetalleDeVenta detalleDeVentaInstance= this.get(id)
            if (detalleDeVentaInstance) {
                detalleDeVentaInstance.activo= false
                this.save(detalleDeVentaInstance)
                return detalleDeVentaInstance.id
            } else {
                throw new Exception("No existe con el id " + id)
            }
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }
    }

}