package com.maintain.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.maintain.model.MaintainenanceTicket;
import com.maintain.model.TicketDAO;

@Component
public class JdbcTicketDAO implements TicketDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcTicketDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<MaintainenanceTicket> getTickets() {
		List<MaintainenanceTicket> tickets = new ArrayList<>();
		String sqlSelectTickets = "SELECT * FROM tickets";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectTickets);
		while (results.next()) {
			tickets.add(mapRowToTicket(results));
		}
		return tickets;
	}

	@Override
	public MaintainenanceTicket getTicket(String sku) {
		MaintainenanceTicket ticket = new MaintainenanceTicket();
		String sqlSelectTicketBySKU = "SELECT * FROM tickets WHERE sku = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectTicketBySKU, sku);
		if (results.next()) {
			ticket = mapRowToTicket(results);
		}
		return ticket;
	}

	@Override
	public MaintainenanceTicket getTicketByID(long id) {
		MaintainenanceTicket ticket = new MaintainenanceTicket();
		String sqlSelectTicketByID = "SELECT * FROM tickets WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectTicketByID, id);
		if (results.next()) {
			ticket = mapRowToTicket(results);
		}
		return ticket;
	}

	private MaintainenanceTicket mapRowToTicket(SqlRowSet row) {
		MaintainenanceTicket ticket = new MaintainenanceTicket();
		ticket.setID(row.getLong("id"));
		ticket.setMessage(row.getString("message"));
		ticket.setSentDate(row.getString("date"));
		ticket.setWorkMaintenanceNotes(row.getString("notes"));
		ticket.setWorkType(row.getString("workType"));
		return ticket;
	}

}
