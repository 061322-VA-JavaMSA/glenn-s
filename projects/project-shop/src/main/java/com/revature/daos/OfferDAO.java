package com.revature.daos;

import java.util.List;

import com.revature.models.Offer;

public interface OfferDAO {
	Offer createOffer(Offer o);
	Offer retrieveOfferById(int id);
	List<Offer> retrieveOffers();
	boolean updateOffer(Offer o);
	boolean deleteOfferById(int id);
	List<Offer> retrieveOfferByUserId(int id);
	boolean acceptOffer(Offer o);
}
