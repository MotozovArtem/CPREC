package io.rienel.cw6.server;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * TODO ArMotozov
 *
 * @since 11/16/2022
 */
@AutoConfiguration
@EnableJpaRepositories
@EnableWebMvc
public class ApplicationConfiguration {
}
