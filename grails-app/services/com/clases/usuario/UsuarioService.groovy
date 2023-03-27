package com.clases.usuario

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class UsuarioService {

    Usuario get(long id) {
        return Usuario.get(id)
    }


    def save(Usuario usuarioInstance) throws Exception {
        if (usuarioInstance && usuarioInstance.validate()) {
            usuarioInstance.save(flush: true)
            return usuarioInstance
        }
        throw new Exception("Errores :${usuarioInstance.errors}")
    }


    def create(Map usuarioMap , Cliente clienteInstance) {
        try {
            Usuario usuarioInstance
            usuarioInstance = new Usuario()
            usuarioInstance.usuario = usuarioMap.usuario
            usuarioInstance.contrasena= usuarioMap.contrasena
            usuarioInstance.cliente = clienteInstance

            return this.save(usuarioInstance)
        } catch (e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }


    def update(Map usuarioMap){
        try {
            Usuario usuarioInstance
            usuarioInstance = this.get(usuarioMap.id as long)
            usuarioInstance.usuario = usuarioMap.usuario
            usuarioInstance.contrasena= usuarioMap.contrasena
            this.save(usuarioInstance)
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }

    }

    def delete(long id){
        try {
            Usuario usuarioInstance= this.get(id)
            if (usuarioInstance) {
                usuarioInstance.activo= false
                this.save(usuarioInstance)
                return usuarioInstance.id
            } else {
                throw new Exception("No existe con el id " + id)
            }
        } catch(e) {
            throw new Exception("Errores :${e.getMessage()}")
        }
    }



}