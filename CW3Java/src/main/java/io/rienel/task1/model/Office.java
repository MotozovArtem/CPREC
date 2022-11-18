package io.rienel.task1.model;

import java.util.UUID;

public class Office {
	private UUID id;
	private String address;
	private String lawAddress;
	private Integer cabinetsCount;

	public Office() {
	}

	public Office(UUID id, String address, String lawAddress, Integer cabinetsCount) {
		this.id = id;
		this.address = address;
		this.lawAddress = lawAddress;
		this.cabinetsCount = cabinetsCount;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLawAddress() {
		return lawAddress;
	}

	public void setLawAddress(String lawAddress) {
		this.lawAddress = lawAddress;
	}

	public Integer getCabinetsCount() {
		return cabinetsCount;
	}

	public void setCabinetsCount(Integer cabinetsCount) {
		this.cabinetsCount = cabinetsCount;
	}

	public static class Builder {
		private UUID id;
		private String address;
		private String lawAddress;
		private Integer cabinetsCount;

		public Office build() {
			Office office = new Office();
			office.setId(id);
			office.setAddress(address);
			office.setCabinetsCount(cabinetsCount);
			office.setLawAddress(lawAddress);
			return office;
		}

		public Builder setId(UUID id) {
			this.id = id;
			return this;
		}

		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder setLawAddress(String lawAddress) {
			this.lawAddress = lawAddress;
			return this;
		}

		public Builder setCabinetsCount(Integer cabinetsCount) {
			this.cabinetsCount = cabinetsCount;
			return this;
		}
	}
}
