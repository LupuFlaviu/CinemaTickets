package com.flaviu.example.cinematickets.ticketing

import com.flaviu.example.cinematickets.data.model.Ticket

class TicketManager {

    fun calculateTotal(ticketList: List<Ticket>): Pair<Double, Double> {
        var savings = 0.0
        var total = 0.0
        for (ticket in ticketList) {
            var ticketTotal = 0.0
            ticketTotal += ticket.price
            if (ticket.hasImax) {
                ticketTotal += ticket.imaxPrice
            }
            if (ticket.hasReal3D) {
                ticketTotal += ticket.real3DPrice
            }
            // TODO: in a production environment, 2 additional tickets (same as the one purchased) should be given to the user if this offer is active
            if (ticket.is3For1) {
                savings += ticketTotal * 2
            }
            total += ticketTotal
        }
        return Pair(total, savings)
    }
}