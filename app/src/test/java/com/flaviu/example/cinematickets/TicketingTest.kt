package com.flaviu.example.cinematickets

import com.flaviu.example.cinematickets.data.model.ConcessionTicket
import com.flaviu.example.cinematickets.data.model.StandardTicket
import com.flaviu.example.cinematickets.data.model.Ticket
import com.flaviu.example.cinematickets.ticketing.TicketManager
import org.junit.Assert
import org.junit.Test

class TicketingTest {

    @Test
    fun total_isCorrect() {
        var list: List<Ticket> = listOf(StandardTicket())
        val ticketManager = TicketManager()
        var totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(7.90, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        list = listOf(ConcessionTicket())
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(5.40, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        list = listOf(StandardTicket(), StandardTicket(), StandardTicket())
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(7.90 * list.size, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        list = listOf(ConcessionTicket(), ConcessionTicket(), ConcessionTicket())
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(5.40 * list.size, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        list = listOf(
            StandardTicket(),
            ConcessionTicket(),
            StandardTicket(),
            ConcessionTicket(),
            ConcessionTicket(),
            StandardTicket()
        )
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(39.90, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        val standardTicketWithReal3D = StandardTicket()
        standardTicketWithReal3D.hasReal3D = true
        list = listOf(standardTicketWithReal3D)
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(8.80, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        val standardTicketWithImax = StandardTicket()
        standardTicketWithImax.hasImax = true
        list = listOf(standardTicketWithImax)
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(9.40, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        val concessionTicketWithReal3D = ConcessionTicket()
        concessionTicketWithReal3D.hasReal3D = true
        list = listOf(concessionTicketWithReal3D)
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(6.30, totals.first, 0.01)
        Assert.assertEquals(0.0, totals.second, 0.0)

        val concessionTicketWithImax = ConcessionTicket()
        concessionTicketWithImax.hasImax = true
        list = listOf(concessionTicketWithImax)
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(6.90, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        list = listOf(
            concessionTicketWithReal3D,
            standardTicketWithImax,
            standardTicketWithReal3D,
            concessionTicketWithImax
        )
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(31.40, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        val standardTicket = StandardTicket()
        standardTicket.hasImax = true
        standardTicket.hasReal3D = true
        list = listOf(standardTicket)
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(10.30, totals.first, 0.0)
        Assert.assertEquals(0.0, totals.second, 0.0)

        val concessionTicket = ConcessionTicket()
        concessionTicket.hasImax = true
        concessionTicket.hasReal3D = true
        list = listOf(concessionTicket)
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(7.80, totals.first, 0.01)
        Assert.assertEquals(0.0, totals.second, 0.0)

        list = listOf(
            concessionTicketWithReal3D,
            standardTicketWithImax,
            concessionTicket,
            concessionTicketWithImax,
            standardTicket
        )
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(40.70, totals.first, 0.04)
        Assert.assertEquals(0.0, totals.second, 0.0)

        standardTicket.is3For1 = true
        list = listOf(standardTicket)
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(10.30, totals.first, 0.0)
        Assert.assertEquals(20.60, totals.second, 0.0)

        concessionTicket.is3For1 = true
        list = listOf(concessionTicket)
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(7.80, totals.first, 0.01)
        Assert.assertEquals(15.60, totals.second, 0.01)

        list = listOf(
            concessionTicketWithReal3D,
            standardTicketWithImax,
            concessionTicket,
            concessionTicketWithImax,
            standardTicket
        )
        totals = ticketManager.calculateTotal(list)
        Assert.assertEquals(40.70, totals.first, 0.04)
        Assert.assertEquals(36.20, totals.second, 0.0)
    }
}