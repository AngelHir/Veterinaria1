package com.clases.usuario

import grails.converters.JSON


class UsuarioController {

    UsuarioService usuarioService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def show(Long id) {
        respond usuarioService.get(id)
    }


    def save() {
        println params
        try {
            usuarioService.create(JSON.parse(request) as Map) as JSON
            Map result = [success: true]
            respond result

        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }

    }


    def update () {
        println params
        try {
            render usuario.update(JSON.parse(request) as Map) as JSON
            Map result = [success: true]
            respond result

        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }
    }

    def delete(long id){

        println params
        try {
            Map result = [success: usuarioService.delete(id)]
            respond result
        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }
    }

}