package com.clases.usuario

import grails.converters.JSON


class ServiciosController {

    ServiciosService serviciosService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /*def obtenerColores(){
        def coloreslist= catalogoColorService.obtenerColores()
        respond(coloreslist)
    }*/

    def save() {
        try {
            serviciosService.create(JSON.parse(request) as Map) as JSON
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
            serviciosService.update(JSON.parse(request) as Map) as JSON
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
            Map result = [success: serviciosService.delete(id)]
            respond result
        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }
    }


}
