package io.rienel.cw6.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "cw6_offer")
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;

	@Column(name = "serial_number")
	private String serialNumber;

	@Column(name = "sign_date")
	private LocalDate signDate;

	@Column(name = "ending_date")
	private LocalDate endingDate;

	@Column(name = "start_date")
	private LocalDate startDate;

	@ManyToOne(targetEntity = Client.class, optional = false)
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne(targetEntity = Office.class, optional = false)
	@JoinColumn(name = "office_id")
	private Office office;

	@ManyToOne(targetEntity = Stuff.class, optional = false)
	@JoinColumn(name = "stuff_id")
	private Stuff stuff;

	public Offer() {
	}

	public Offer(UUID id, String serialNumber, LocalDate signDate, LocalDate endingDate,
	             LocalDate startDate, Client client, Office office, Stuff stuff) {
		this.id = id;
		this.serialNumber = serialNumber;
		this.signDate = signDate;
		this.endingDate = endingDate;
		this.startDate = startDate;
		this.client = client;
		this.office = office;
		this.stuff = stuff;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public LocalDate getSignDate() {
		return signDate;
	}

	public void setSignDate(LocalDate signDate) {
		this.signDate = signDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Stuff getStuff() {
		return stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	@Override
	public String toString() {
		return "Offer{" +
		       "id=" + id +
		       ", serialNumber='" + serialNumber + '\'' +
		       ", signDate=" + signDate +
		       ", endingDate=" + endingDate +
		       ", startDate=" + startDate +
		       ", client=" + client +
		       ", office=" + office +
		       ", stuff=" + stuff +
		       '}';
	}

	public static class Builder {
		private UUID id;
		private String serialNumber;
		private LocalDate signDate;
		private LocalDate endingDate;
		private LocalDate startDate;
		private Client client;
		private Office office;
		private Stuff stuff;

		public Offer build() {
			Offer offer = new Offer();
			offer.setId(id);
			offer.setSerialNumber(serialNumber);
			offer.setClient(client);
			offer.setOffice(office);
			offer.setStuff(stuff);
			offer.setSignDate(signDate);
			offer.setStartDate(startDate);
			offer.setEndingDate(endingDate);
			return offer;
		}

		public Builder setId(UUID id) {
			this.id = id;
			return this;
		}

		public Builder setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
			return this;
		}

		public Builder setSignDate(LocalDate signDate) {
			this.signDate = signDate;
			return this;
		}

		public Builder setEndingDate(LocalDate endingDate) {
			this.endingDate = endingDate;
			return this;
		}

		public Builder setStartDate(LocalDate startDate) {
			this.startDate = startDate;
			return this;
		}

		public Builder setClient(Client client) {
			this.client = client;
			return this;
		}

		public Builder setOffice(Office office) {
			this.office = office;
			return this;
		}

		public Builder setStuff(Stuff stuff) {
			this.stuff = stuff;
			return this;
		}
	}
}
