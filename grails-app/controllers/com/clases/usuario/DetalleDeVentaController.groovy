package com.clases.usuario

import grails.converters.JSON

class DetalleDeVentaController {

    DetalleDeVentaService detalleDeVentaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def show(Long id) {
        respond detalleDeVentaService.get(id)
    }


    def save() {
        println params
        try {
            detalleDeVentaService.create(JSON.parse(request) as Map) as JSON
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
            render detalleDeVentaService.update(JSON.parse(request) as Map) as JSON
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
            Map result = [success: detalleDeVentaService.delete(id)]
            respond result
        } catch (Exception e) {
            Map error = [error: e.getMessage()]
            render error as JSON
        }
    }
}
