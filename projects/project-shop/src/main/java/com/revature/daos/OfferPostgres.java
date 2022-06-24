package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Offer;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OfferDAO {
	private String _table  = "offers";
	private static Logger log = LogManager.getLogger(OfferPostgres.class);

	@Override
	public Offer createOffer(Offer o) {
		String sql = "insert into "+ _table +" (offer_price , product_id, user_id  ) values (?,?,?) returning id;";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setDouble(1, o.getOffer_price());
			ps.setInt(2, o.getProduct_id());
			ps.setInt(2, o.getUser_id());

			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if (rs.next()) {
				o.setId(rs.getInt("id"));
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

	@Override
	public Offer retrieveOfferById(int id) {
		String sql = "select * from "+ _table +" where id = ?";
		Offer offer = null;
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
		 
			if (rs.next()) {
				offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setOffer_price(rs.getDouble("offer_price"));
				offer.setProduct_id(rs.getInt("product_id"));
				offer.setUser_id(rs.getInt("user_id"));
				offer.setStatus(rs.getInt("status"));
				offer.setCreated_at(rs.getTimestamp("created_at"));
			}
		} catch (SQLException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return offer;
	}

	@Override
	public List<Offer> retrieveOffers() {
		// TODO Auto-generated method stub
		String sql = "select * from "+ _table +";";
		List<Offer> offers = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				// extract each field from rs for each record, map them to a Offer object and
				// add them to the offers arrayliost
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setOffer_price(rs.getDouble("offer_price"));
				offer.setProduct_id(rs.getInt("product_id"));
				offer.setUser_id(rs.getInt("user_id"));
				offer.setStatus(rs.getInt("status"));
				offer.setCreated_at(rs.getTimestamp("created_at"));
				offers.add(offer);

			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offers;
	}


	@Override
	public List<Offer> retrieveOffers(int status) {
		// TODO Auto-generated method stub
		String sql = "select * from "+ _table +" where status = ?;";
		List<Offer> offers = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, status);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				// extract each field from rs for each record, map them to a Offer object and
				// add them to the offers arrayliost
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setOffer_price(rs.getDouble("offer_price"));
				offer.setProduct_id(rs.getInt("product_id"));
				offer.setUser_id(rs.getInt("user_id"));
				offer.setStatus(rs.getInt("status"));
				offer.setCreated_at(rs.getTimestamp("created_at"));
				offers.add(offer);

			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offers;
	}
	
	@Override
	public boolean updateOffer(Offer o) {
		// TODO Auto-generated method stub
		String sql = "update "+ _table +" set offer_price = ?,  where id = ?;";
		int rowsChanged = -1;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setDouble(2, o.getOffer_price());
			ps.setInt(3, o.getId());
			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rowsChanged < 1) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteOfferById(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from "+ _table +" where id = ?;";
		int rowsChanged = -1;
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rowsChanged < 1) {
			return false;
		}
		return true;
	}

	@Override
	public List<Offer> retrieveOfferByUserId(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from "+ _table +" where user_id = ?";
		List<Offer> offers = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// extract each field from rs for each record, map them to a Offer object and
				// add them to the offers arrayliost
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setOffer_price(rs.getDouble("offer_price"));
				offer.setProduct_id(rs.getInt("product_id"));
				offer.setUser_id(rs.getInt("user_id"));
				offer.setStatus(rs.getInt("status"));
				offer.setCreated_at(rs.getTimestamp("created_at"));
				offers.add(offer);

			}
		} catch (SQLException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return offers;
	}
	
	/*
	 * rowsChanged_2 is not verified because when there is only 1 offer
	 */
	@Override
	public boolean acceptOffer(Offer o) {
 		String sql_1 = "update "+ _table +" set status = 1 where id = ?;";
		String sql_2 = "update "+ _table +" set status = 2 where id != ? and product_id = ?;";
		int rowsChanged_1 = -1 , rowsChanged_2 = -1;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
 
 
			PreparedStatement ps_1 = c.prepareStatement(sql_1);
			ps_1.setInt(1, o.getId());
			rowsChanged_1 = ps_1.executeUpdate();

			PreparedStatement ps_2 = c.prepareStatement(sql_2);
			ps_2.setInt(1, o.getId());
			ps_2.setInt(2, o.getProduct_id());
			 
			rowsChanged_2 = ps_2.executeUpdate();
			
			if (rowsChanged_1 < 1) {
				return false;
			}			
		} catch (SQLException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}
	
    /*
     * return true when no other offers accepted   
     */
	@Override
	public boolean verifyAcceptOffer(Offer o) {
		// TODO Auto-generated method stub
		String sql = "select * from "+ _table +" where product_id = ? and status = 1";
		Offer offer = null;
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getProduct_id());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return false;
			}
		} catch (SQLException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return true;
	}

 

}
