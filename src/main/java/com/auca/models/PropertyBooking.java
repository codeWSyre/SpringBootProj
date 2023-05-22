package com.auca.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PropertyBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private Long buyerId;
    private String buyerEmail;
    private String checkInDate;
    private String checkOutDate;
	public PropertyBooking() {
		super();
	}
	public PropertyBooking(Long id, String location, Long buyerId, String buyerEmail, String checkInDate,
			String checkOutDate) {
		super();
		this.id = id;
		this.location = location;
		this.buyerId = buyerId;
		this.buyerEmail = buyerEmail;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

    // Constructors, getters, and setters

  
}
