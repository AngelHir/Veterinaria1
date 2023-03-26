package com.clases.usuario

import grails.converters.JSON

class VentaController {

    VentaService ventaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def show(Long id) {
        respond ventaService.get(id)
    }

    def save() {
        try {
            ventaService.create(JSON.parse(request) as Map) as JSON
            Map result = [success: true]
            respond result

        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }

    }


    def update () {

        try {
            render ventaService.update(JSON.parse(request) as Map) as JSON
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
            Map result = [success: ventaService.delete(id)]
            respond result
        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }
    }
}
