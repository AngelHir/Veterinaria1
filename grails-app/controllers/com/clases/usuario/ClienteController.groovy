package com.clases.usuario

import grails.converters.JSON


class ClienteController {

    ClienteService clienteService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def show(Long id) {
        respond calzadoService.get(id)
    }

    def save() {
        try {
            def jsonObj = JSON.parse(request)
            println "jsonObj: ${jsonObj}"
            calzadoService.create(jsonObj as Map) as JSON
            Map result = [success: true]
            respond result

        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }

    }


    def update () {

        try {
            render calzadoService.update(JSON.parse(request) as Map) as JSON
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
            Map result = [success: calzadoService.delete(id)]
            respond result
        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }
    }

}
