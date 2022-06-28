package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Payment;
import com.revature.util.ConnectionUtil;

public class PaymentPostgres implements PaymentDAO {
	private String _table = "payment";

	@Override
	public Payment createPayment(Payment p) {
		String sql = "insert into  " + _table + " (paid, payment_connection_id) values (?,?) returning id;";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setDouble(1, p.getPaid());
			ps.setInt(2, p.getPayment_connection_id());
			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if (rs.next()) {
				p.setId(rs.getInt("id"));
 			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Payment retrievePaymentById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from " + _table + "  where id = ?;";
		Payment payment = null;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				payment = new Payment();
				returnData(rs, payment);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payment;
	}

	@Override
	public List<Payment> retrievePayments() {
		// TODO Auto-generated method stub
		String sql = "select * from  " + _table + " order by created_at desc;";
		List<Payment> payment = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Payment u = new Payment();
				returnData(rs, u);

				payment.add(u);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return payment;
	}

	@Override
	public boolean updatePayment(Payment p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePaymentById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Payment returnData(ResultSet rs, Payment payment) {
		// TODO Auto-generated method stub
		try {
			payment.setId(rs.getInt("id"));
			payment.setPaid(rs.getDouble("paid"));
			payment.setPayment_connection_id(rs.getInt("payment_connection_id"));
			payment.setCreated_at(rs.getTimestamp("created_at"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return payment;
	}

	@Override
	public Payment retrievefirstPaymentByUserId(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from " + _table + "  where payment_connection_id = ? order by created_at asc limit 1;";
		Payment payment = null;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				payment = new Payment();
				returnData(rs, payment);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payment;
	}

	@Override
	public List<Payment> retrievePaymentsByConnID(int id) {
		// TODO Auto-generated method stub
		List<Payment> payments = new ArrayList<>();

		String sql = "select * from " + _table + " where payment_connection_id = ? order by created_at asc";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Payment payment = new Payment();
				returnData(rs, payment);
				payments.add(payment);

			}
		} catch (SQLException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return payments;
	}

	@Override
	public double retrievePaymentsSumByPC(int cid) {
		String sql = "select sum(paid) as total from " + _table + "  where payment_connection_id = ? ;";
		double sum_payment = 0;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, cid); 

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				sum_payment = rs.getDouble("total");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum_payment;
	}

	 

}
