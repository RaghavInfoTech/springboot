package com.info.springboot.crud.service;

import com.info.springboot.crud.dao.BookDao;
import com.info.springboot.crud.dao.TicketDao;
import com.info.springboot.crud.entity.Book;
import com.info.springboot.crud.entity.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class , provides service to all REST APIs and calls DAO layer
 *
 * @author Raghava
 */
@Service
public class TicketService {

	@Autowired
	private TicketDao ticketRepo;

	public Ticket bookTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	public Ticket getTicket(Integer id) {
		 Ticket ticket = ticketRepo.getOne(id);
		 System.out.println(ticket);
		 return  ticket;
	}

	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketRepo.deleteById(ticketId);
		
	}

}
