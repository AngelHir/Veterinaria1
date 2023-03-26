package com.clases.usuario

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VentaServiceSpec extends Specification {

    VentaService ventaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Venta(...).save(flush: true, failOnError: true)
        //new Venta(...).save(flush: true, failOnError: true)
        //Venta venta = new Venta(...).save(flush: true, failOnError: true)
        //new Venta(...).save(flush: true, failOnError: true)
        //new Venta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //venta.id
    }

    void "test get"() {
        setupData()

        expect:
        ventaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Venta> ventaList = ventaService.list(max: 2, offset: 2)

        then:
        ventaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ventaService.count() == 5
    }

    void "test delete"() {
        Long ventaId = setupData()

        expect:
        ventaService.count() == 5

        when:
        ventaService.delete(ventaId)
        sessionFactory.currentSession.flush()

        then:
        ventaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Venta venta = new Venta()
        ventaService.save(venta)

        then:
        venta.id != null
    }
}
