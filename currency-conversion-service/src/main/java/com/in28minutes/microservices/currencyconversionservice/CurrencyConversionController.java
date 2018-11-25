package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	@Autowired
	Environment environment;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyconversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> URIVariables = new HashMap<>();
		URIVariables.put("from", from);
		URIVariables.put("to", to);
		String url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
		ResponseEntity<CurrencyconversionBean> responseEntity = new RestTemplate().getForEntity(url,
				CurrencyconversionBean.class, URIVariables);
		CurrencyconversionBean response = responseEntity.getBody();

		return new CurrencyconversionBean(response.getId(), from, to, response.getConversionrate(), quantity,
				quantity.multiply(response.getConversionrate()), 8080);
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyconversionBean convertCurrencyfeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		logger.info("Inside CurrencyConversionController#CurrencyconversionBean");
		CurrencyconversionBean response = proxy.getExchangeValue(from, to);
		return new CurrencyconversionBean(response.getId(), from, to, response.getConversionrate(), quantity,
				quantity.multiply(response.getConversionrate()),
				response.getPort());
	}
}
