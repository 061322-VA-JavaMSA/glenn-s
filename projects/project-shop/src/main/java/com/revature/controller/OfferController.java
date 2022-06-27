package com.revature.controller;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Offer;
import com.revature.models.User;
import com.revature.services.OfferServices;
import com.revature.services.UserService;

public class OfferController {
	private Offer o;
	private OfferServices os;
	private User u;
	private UserService us;
	private Scanner input = null;

	public OfferController() {
		o = new Offer();
		os = new OfferServices();
		u = new User();
		us = new UserService();
	}

	public void displayoffers() {
		List<Offer> offers = os.getOffers(0);
		if (offers != null && offers.size() > 0) {
			System.out.println("Offers: ");
			for (Offer offer : offers) {
				singlelist(offer);
			}
		}

	}
	
	public void acceptoffers() {
		input = new Scanner(System.in);
		int id = 0;
		System.out.println("Offer Reject");
		System.out.println("Ener Offer ID");
		id = input.nextInt();
		Offer o = os.getOfferByID(id);
		int allow = 0;
		if (o == null) {
			System.out.println("Cannot find offer");
		} 		
		if (o != null) {
			if(os.verifyAcceptOffer(o.getProduct_id()) == false) {
				System.out.println("Another offer has already been accepted");
			} else {
				allow = 1;
			}
			
		}
		if (allow == 1){
			singlelist(o);
			System.out.println("Do you want to accept this Offer? Y/N");
			String choice = input.next();
			switch (choice) {
			case "y":
			case "Y":
				System.out.println("Offer has been accepted");
				os.acceptOffer(o);
				
				break;
			case "n":
			case "N":
			default:
				System.out.println("Offer was not accepted");
				break;

			}

		}		
	}
	
	public void rejectoffers() {
		input = new Scanner(System.in);
		int id = 0;
		System.out.println("Offer Reject");
		System.out.println("Ener Offer ID");
		id = input.nextInt();
		Offer o = os.getOfferByID(id);

		if (o == null) {
			System.out.println("Cannot find offer");
		} else {
			singlelist(o);
			System.out.println("Do you want to reject this Offer? Y/N");
			String choice = input.next();
			switch (choice) {
			case "y":
			case "Y":
				System.out.println("Offer has been rejected");
				os.rejectOffer(id);
				break;
			case "n":
			case "N":
			default:
				System.out.println("Offer was not rejected");
				break;

			}

		}

	}

	public void singlelist(Offer offer) {
		u = us.retrieveUserById(offer.getUser_id());
		System.out.println("ID: " + offer.getId() + " Date: " + offer.getCreated_at().toLocalDateTime() + " Paid: "
				+ offer.getOffer_price() + " Customer name: " + u.getUsername());

	}
}
