package io.rienel.converter;

public interface Converter<Domain, DTO> {
	Domain toDomain(DTO dto);

	DTO toDto(Domain domain);
}
