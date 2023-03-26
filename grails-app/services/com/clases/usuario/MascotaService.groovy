package com.clases.usuario

import grails.gorm.transactions.Transactional

@Transactional
class MascotaService {

    Mascota get(long id) {
        return Mascota.get(id)
    }


    def save(Mascota mascotaInstance) throws Exception {
        if (mascotaInstance && mascotaInstance.validate()) {
            mascotaInstance.save(flush: true)
            return mascotaInstance
        }
        throw new Exception("Errores :${mascotaInstance.errors}")
    }


    def create(Map mascotaMap, Cliente clienteInstance) {
        try {
            Mascota mascotaInstance
            mascotaInstance = new Mascota()
            mascotaInstance.nombre = mascotaMap.nombre
            mascotaInstance.raza = mascotaMap.raza
            mascotaInstance.peso = mascotaMap.peso as float
            mascotaInstance.cliente = clienteInstance
            return this.save(mascotaInstance)
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }


    def update(Map mascotaMap){
        try {
            Mascota mascotaInstance
            mascotaInstance = this.get(mascotaMap.id as long)
            mascotaInstance.nombre = mascotaMap.nombre
            mascotaInstance.raza = mascotaMap.raza
            mascotaInstance.peso = mascotaMap.peso as float
            this.save(mascotaInstance)
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }

    def delete(long id){
        try {
            Mascota mascotaInstance= this.get(id)
            if (mascotaInstance) {
                mascotaInstance.activo= false
                this.save(mascotaInstance)
                return mascotaInstance.id
            } else {
                throw new Exception("No existe con el id " + id)
            }
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }
    }


}