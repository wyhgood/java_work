package com.travel.repository.ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.ticket.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>,
		JpaSpecificationExecutor<Ticket> {

	public List<Ticket> findByThirdId(String thirdId);
}
