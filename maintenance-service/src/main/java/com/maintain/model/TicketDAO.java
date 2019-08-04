package com.maintain.model;

import java.util.List;

public interface TicketDAO {

	MaintainenanceTicket getTicketByID(long id);

	MaintainenanceTicket getTicket(String sku);

	List<MaintainenanceTicket> getTickets();
}