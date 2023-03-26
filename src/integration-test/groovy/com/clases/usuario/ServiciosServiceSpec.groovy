package com.clases.usuario

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ServiciosServiceSpec extends Specification {

    ServiciosService serviciosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Servicios(...).save(flush: true, failOnError: true)
        //new Servicios(...).save(flush: true, failOnError: true)
        //Servicios servicios = new Servicios(...).save(flush: true, failOnError: true)
        //new Servicios(...).save(flush: true, failOnError: true)
        //new Servicios(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //servicios.id
    }

    void "test get"() {
        setupData()

        expect:
        serviciosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Servicios> serviciosList = serviciosService.list(max: 2, offset: 2)

        then:
        serviciosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        serviciosService.count() == 5
    }

    void "test delete"() {
        Long serviciosId = setupData()

        expect:
        serviciosService.count() == 5

        when:
        serviciosService.delete(serviciosId)
        sessionFactory.currentSession.flush()

        then:
        serviciosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Servicios servicios = new Servicios()
        serviciosService.save(servicios)

        then:
        servicios.id != null
    }
}
