package com.clases.usuario

import grails.gorm.transactions.Transactional

@Transactional
class ServiciosService {

    Servicios get(long id) {
        return Servicios.get(id)
    }


    def save(Servicios serviciosInstance) throws Exception {
        if (serviciosInstance && serviciosInstance.validate()) {
            serviciosInstance.save(flush: true)
            return serviciosInstance
        }
        throw new Exception("Errores :${serviciosInstance.errors}")
    }


    def create(Map serviciosMap) {
        try {
            Servicios serviciosInstance
            serviciosInstance = new Servicios()
            serviciosInstance.nombre = serviciosMap.nombre
            serviciosInstance.descripcion = serviciosMap.descripcion
            serviciosInstance.precio = serviciosMap.precio as float

            return this.save(serviciosInstance)
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }


    def update(Map serviciosMap) {
        try {
            Servicios serviciosInstance
            serviciosInstance = this.get(serviciosMap.id as long)
            serviciosInstance.nombre = serviciosMap.nombre
            serviciosInstance.descripcion = serviciosMap.descripcion
            serviciosInstance.precio = serviciosMap.precio as float
            this.save(serviciosInstance)
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }

    def delete(long id) {
        try {
            Servicios serviciosInstance = this.get(id)
            if (serviciosInstance) {
                serviciosInstance.activo = false
                this.save(serviciosInstance)
                return serviciosInstance.id
            } else {
                throw new Exception("No existe con el id " + id)
            }
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }
    }
}