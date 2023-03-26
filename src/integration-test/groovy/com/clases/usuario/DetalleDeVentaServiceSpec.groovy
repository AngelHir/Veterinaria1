package com.clases.usuario

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DetalleDeVentaServiceSpec extends Specification {

    DetalleDeVentaService detalleDeVentaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DetalleDeVenta(...).save(flush: true, failOnError: true)
        //new DetalleDeVenta(...).save(flush: true, failOnError: true)
        //DetalleDeVenta detalleDeVenta = new DetalleDeVenta(...).save(flush: true, failOnError: true)
        //new DetalleDeVenta(...).save(flush: true, failOnError: true)
        //new DetalleDeVenta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //detalleDeVenta.id
    }

    void "test get"() {
        setupData()

        expect:
        detalleDeVentaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DetalleDeVenta> detalleDeVentaList = detalleDeVentaService.list(max: 2, offset: 2)

        then:
        detalleDeVentaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        detalleDeVentaService.count() == 5
    }

    void "test delete"() {
        Long detalleDeVentaId = setupData()

        expect:
        detalleDeVentaService.count() == 5

        when:
        detalleDeVentaService.delete(detalleDeVentaId)
        sessionFactory.currentSession.flush()

        then:
        detalleDeVentaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DetalleDeVenta detalleDeVenta = new DetalleDeVenta()
        detalleDeVentaService.save(detalleDeVenta)

        then:
        detalleDeVenta.id != null
    }
}
