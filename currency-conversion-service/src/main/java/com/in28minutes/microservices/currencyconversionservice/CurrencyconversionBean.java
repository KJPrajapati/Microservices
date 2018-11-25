package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;



public class CurrencyconversionBean {
	
	private long id;
	private String from;
	private String to;
	private BigDecimal conversionrate;
	private BigDecimal quantity;
	private BigDecimal convertedAmount;
	private int port;
	public CurrencyconversionBean() {

	}
	public CurrencyconversionBean(long id, String from, String to, BigDecimal conversionrate, BigDecimal quantity,
			BigDecimal convertedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionrate = conversionrate;
		this.quantity = quantity;
		this.convertedAmount = convertedAmount;
		this.port = port;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionrate() {
		return conversionrate;
	}
	public void setConversionrate(BigDecimal conversionrate) {
		this.conversionrate = conversionrate;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	

}
