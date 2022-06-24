package com.revature.services;

 
import java.util.List;

import com.revature.daos.OfferDAO;
import com.revature.daos.OfferPostgres;
import com.revature.models.Offer;
import com.revature.models.Product;

public class OfferServices {
	OfferDAO od = new OfferPostgres();  
	
	public List<Offer> getOffers() {
		return od.retrieveOffers();
	}

	public List<Offer> getOffers(int status) {
		return od.retrieveOffers(status);
	}	
	
	public Offer createOffer(Offer os) {
		return od.createOffer(os);
	}

	public Offer getOfferByID(int id) {
		return od.retrieveOfferById(id);
	}

	public boolean setOffer(Offer os) {
		return od.updateOffer(os);
	}

	public boolean deleteOfferById(int id) {
		return od.deleteOfferById(id);
	}
	
	public List<Offer> retrieveProductByUserId(int id) {
		return od.retrieveOfferByUserId(id);
	}	
	
	public boolean acceptOffer(Offer os) {
		return od.acceptOffer(os);
	}

	public boolean verifyAcceptOffer(Offer os) {
		return od.verifyAcceptOffer(os);
	}
	
}
