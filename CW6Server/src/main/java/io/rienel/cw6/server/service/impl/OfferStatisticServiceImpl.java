package io.rienel.cw6.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import io.rienel.cw6.server.dto.OfferStatistic;
import io.rienel.cw6.server.model.Client;
import io.rienel.cw6.server.model.Offer;
import io.rienel.cw6.server.repository.ClientRepository;
import io.rienel.cw6.server.repository.OfferRepository;
import io.rienel.cw6.server.service.OfferStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO ArMotozov
 *
 * @since 11/27/2022
 */
@Service
public class OfferStatisticServiceImpl implements OfferStatisticService {

	private final OfferRepository offerRepository;

	private final ClientRepository clientRepository;

	@Autowired
	public OfferStatisticServiceImpl(final OfferRepository offerRepository, final ClientRepository clientRepository) {
		this.offerRepository = offerRepository;
		this.clientRepository = clientRepository;
	}

	@Override
	public OfferStatistic getOfferStatistic() {
		OfferStatistic.Builder statisticBuilder = new OfferStatistic.Builder();
		List<Offer> offers = offerRepository.findAll();
		Map<String, Integer> clientStatistic = new HashMap<>();
		Map<String, Integer> stuffStatistic = new HashMap<>();
		offers.forEach(offer -> {
			if (clientStatistic.containsKey(offer.getClient().getSurname())) {
				clientStatistic.compute(offer.getClient().getSurname(), (k, v) -> v + 1);
			} else {
				clientStatistic.put(offer.getClient().getSurname(), 1);
			}
			if (stuffStatistic.containsKey(offer.getStuff().getSurname())) {
				stuffStatistic.compute(offer.getStuff().getSurname(), (k, v) -> v + 1);
			} else {
				stuffStatistic.put(offer.getStuff().getSurname(), 1);
			}
		});
		statisticBuilder.setStuffStatistics(stuffStatistic);
		statisticBuilder.setClientStatistics(clientStatistic);
		Set<String> clientSurnames = clientRepository.findAll()
				.stream()
				.map(Client::getSurname)
				.collect(Collectors.toSet());
		statisticBuilder.setClientSurnames(clientSurnames);
		return statisticBuilder.build();
	}
}
