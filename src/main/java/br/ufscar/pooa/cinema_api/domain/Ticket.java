package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.PaymentMethod;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

public class Ticket {
	private Long id;
	private Instant paymentDate;
	private Integer priceInCents;
	private Session session;
	private Client client;
	private Seat seat;
	private Set<PaymentMethod> paymentMethods;

	public Ticket() {
	}

	public Ticket(Instant paymentDate, Integer priceInCents, Session session, Client client, Seat seat, Set<PaymentMethod> paymentMethods) {
		this.paymentDate = paymentDate;
		this.priceInCents = priceInCents;
		this.session = session;
		this.client = client;
		this.seat = seat;
		this.paymentMethods = paymentMethods;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Instant paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getPriceInCents() {
		return priceInCents;
	}

	public void setPriceInCents(Integer priceInCents) {
		this.priceInCents = priceInCents;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Set<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(Set<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Ticket ticket = (Ticket) o;
		return Objects.equals(paymentDate, ticket.paymentDate) && Objects.equals(priceInCents, ticket.priceInCents) && Objects.equals(session, ticket.session) && Objects.equals(client, ticket.client) && Objects.equals(seat, ticket.seat) && Objects.equals(paymentMethods, ticket.paymentMethods);
	}

	@Override
	public int hashCode() {
		return Objects.hash(paymentDate, priceInCents, session, client, seat, paymentMethods);
	}
}