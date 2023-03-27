package com.clases.usuario

import grails.gorm.transactions.Transactional

@Transactional
class ClienteService {

    MascotaService mascotaService

    UsuarioService usuarioService

    Cliente get(long id) {
        return Cliente.get(id)
    }


    def save(Cliente clienteInstance) throws Exception {
        if (clienteInstance && clienteInstance.validate()) {
            clienteInstance.save(flush: true)
            return clienteInstance
        }
        throw new Exception("Errores :${clienteInstance.errors}")
    }


    def create(Map clienteMap) {
        try {
            Cliente clienteInstance
            clienteInstance = new Cliente()
            clienteInstance.nombre = clienteMap.nombre
            clienteInstance.apellido= clienteMap.apellido
            clienteInstance.telefono=clienteMap.telefono
            clienteInstance.email=clienteMap.email
            clienteInstance.direccion=clienteMap.direccion
            clienteInstance.usuario=usuarioService.create(clienteMap)
            this.save(clienteInstance)
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }


    def update(Map clienteMap){
        try {
            Cliente clienteInstance
            clienteInstance = this.get(clienteMap.id as long)
            clienteInstance.nombre = clienteMap.nombre
            clienteInstance.apellido= clienteMap.apellido
            clienteInstance.telefono=clienteMap.telefono
            clienteInstance.email=clienteMap.email
            clienteInstance.direccion=clienteMap.direccion
            clienteMap.mascotas.each {Map mascotaMap
                ->clienteInstance.addToMascotas(mascotaService.create(mascotaMap,clienteInstance))}
            this.save(clienteInstance)
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }

    def delete(long id){
        try {
            Cliente clienteInstance = this.get(id)
            if (clienteInstance) {
                clienteInstance.activo= false
                this.save(clienteInstance)
                return clienteInstance.id
            } else {
                throw new Exception("No existe con el id " + id)
            }
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }
    }

}




