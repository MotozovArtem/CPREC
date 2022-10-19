package io.rienel;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyApplication {

	private static final Logger log = LoggerFactory.getLogger(CurrencyApplication.class);

	private static final String APP_NAME = "Currency Viewer";

	public static void main(String[] args) {
		log.info("{} started", APP_NAME);
		JFrame app = new JFrame(APP_NAME);
		app.setSize(400, 600);
		app.setLayout(null);
		app.setVisible(true);
	}

}