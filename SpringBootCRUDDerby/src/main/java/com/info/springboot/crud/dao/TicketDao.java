package com.info.springboot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.springboot.crud.entity.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket,Integer>{

	
}
