package io.rienel.cw6.server.dto;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO ArMotozov
 *
 * @since 11/27/2022
 */
public class OfferStatistic {

	@JsonProperty("stuff_statistics")
	private Map<String, Integer> stuffStatistics;

	@JsonProperty("client_statistics")
	private Map<String, Integer> clientStatistics;

	@JsonProperty("client_surnames")
	private Set<String> clientSurnames;

	public OfferStatistic() {
	}

	public OfferStatistic(Map<String, Integer> stuffStatistics, Map<String, Integer> clientStatistics, Set<String> clientSurnames) {
		this.stuffStatistics = stuffStatistics;
		this.clientStatistics = clientStatistics;
		this.clientSurnames = clientSurnames;
	}

	public Map<String, Integer> getStuffStatistics() {
		return stuffStatistics;
	}

	public void setStuffStatistics(Map<String, Integer> stuffStatistics) {
		this.stuffStatistics = stuffStatistics;
	}

	public Map<String, Integer> getClientStatistics() {
		return clientStatistics;
	}

	public void setClientStatistics(Map<String, Integer> clientStatistics) {
		this.clientStatistics = clientStatistics;
	}

	public Set<String> getClientSurnames() {
		return clientSurnames;
	}

	public void setClientSurnames(Set<String> clientSurnames) {
		this.clientSurnames = clientSurnames;
	}

	public static class Builder {
		private Map<String, Integer> stuffStatistics;
		private Map<String, Integer> clientStatistics;
		private Set<String> clientSurnames;

		public Builder setStuffStatistics(Map<String, Integer> stuffStatistics) {
			this.stuffStatistics = stuffStatistics;
			return this;
		}

		public Builder setClientStatistics(Map<String, Integer> clientStatistics) {
			this.clientStatistics = clientStatistics;
			return this;
		}

		public Builder setClientSurnames(Set<String> clientSurnames) {
			this.clientSurnames = clientSurnames;
			return this;
		}

		public OfferStatistic build() {
			return new OfferStatistic(stuffStatistics, clientStatistics, clientSurnames);
		}
	}
}
