package io.rienel.task1.model;

import java.time.LocalDate;
import java.util.UUID;

public class Offer {
	private UUID id;
	private String serialNumber;
	private LocalDate signDate;
	private LocalDate endingDate;
	private LocalDate startDate;
	private Client client;
	private Office office;
	private Stuff stuff;

	public Offer() {
	}

	public Offer(UUID id, String serialNumber, LocalDate signDate, LocalDate endingDate, LocalDate startDate, Client client, Office office, Stuff stuff) {
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
