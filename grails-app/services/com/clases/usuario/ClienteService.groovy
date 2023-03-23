package com.clases.usuario

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class ClienteService {

    Cliente get(long id) {
        return Autor.get(id)
    }

    def show(long id) {
        println params
        try {
            Cliente clienteInstance = clienteService.get(id)
            if (clienteInstance) {
                render clienteInstance as JSON
            } else {
                throw new Exception("No existe con el id " + id)
            }
        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }
    }


    def save(Cliente clienteInstance) throws Exception {
        if (clienteInstance && clienteInstance.validate()) {
            clienteInstance.save(flush: true)
            return clienteInstance
        }
        throw new Exception("Errores :${clienteInstance.errors}")
    }


    def create(Map autorMap) {
        try {
            Cliente clienteInstance
            clienteInstance = new Cliente()
            clienteInstance.pesona=personaService.create(autorMap)
            clienteInstance.editorial = autorMap.editorial
            clienteInstance.ranking = autorMap.ranking as short
            this.save(clienteInstance)
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }


    def update(Map autorMap){
        try {
            Cliente clienteInstance
            clienteInstance = this.get(autorMap.id as long)
            clienteInstance.editorial = autorMap.editorial
            clienteInstance.ranking = autorMap.ranking as short
            autorMap.libros.each {Map libroMap ->clienteInstance.addToLibros(libroService.create(libroMap,clienteInstance))}
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




