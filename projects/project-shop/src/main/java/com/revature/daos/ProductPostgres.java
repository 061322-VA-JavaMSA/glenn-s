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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Product;

import com.revature.util.ConnectionUtil;

public class ProductPostgres implements ProductDAO {
	private String _table  = "products";
	private static Logger log = LogManager.getLogger(ProductPostgres.class);

	@Override
	public Product createProduct(Product p) {
		String sql = "insert into "+ _table +" (product_name, price) values (?,?) returning id;";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p.getProduct_name());
			ps.setDouble(2, p.getPrice());

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
	public Product retrieveProductById(int id) {
		String sql = "select * from "+ _table +" where id = ?";
		Product product = null;
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				product.setOffer_price(rs.getDouble("offer_price"));
				product.setPaid(rs.getDouble("paid"));
				product.setPaid_at(rs.getTimestamp("paid_at"));
				product.setUser_id(rs.getInt("user_id"));

			}
		} catch (SQLException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> retrieveProducts() {
		// TODO Auto-generated method stub
		String sql = "select * from "+ _table +";";
		List<Product> products = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				// extract each field from rs for each record, map them to a Product object and
				// add them to the products arrayliost
				Product product = new Product();
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				product.setOffer_price(rs.getDouble("offer_price"));
				product.setPaid(rs.getDouble("paid"));
				product.setPaid_at(rs.getTimestamp("paid_at"));
				product.setUser_id(rs.getInt("user_id"));
				products.add(product);

			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public boolean updateProduct(Product p) {
		String sql = "update "+ _table +" set product_name = ?, price = ? where id = ?;";
		int rowsChanged = -1;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, p.getProduct_name());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getId());

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
	public boolean deleteProductById(int id) {
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
	public boolean setProducttoUser(Product p) {
		String sql = "update "+ _table +" set offer_price = ?, paid = ? , paid_at = ?, user_id = > where id = ?;";
		int rowsChanged = -1;
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());

		Date date = new Date();
		Timestamp timestamp2 = new Timestamp(date.getTime());
		p.setPaid_at(timestamp2);

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setDouble(1, p.getOffer_price());
			ps.setDouble(2, p.getPaid());
			ps.setTimestamp(3, p.getPaid_at());
			ps.setInt(4, p.getUser_id());
			ps.setInt(5, p.getId());

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
	public boolean resetProduct(Product p) {
		String sql = "update "+ _table +" set offer_price = ?, paid = ? , paid_at = ? , paid_at = ?, user_id = >  where id = ?;";
		int rowsChanged = -1;

		p.setOffer_price(0);
		p.setPaid(0);
		p.setPaid_at(null);
		p.setUser_id(0);

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setDouble(1, p.getOffer_price());
			ps.setDouble(2, p.getPaid());
			ps.setTimestamp(3, p.getPaid_at());
			ps.setInt(4, p.getUser_id());

			ps.setInt(4, p.getId());

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
	public boolean payProduct(Product p) {
		String sql = "update "+ _table +" set paid = ? where id = ?;";
		int rowsChanged = -1;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setDouble(2, p.getPaid());
			ps.setInt(4, p.getId());

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
	public List<Product> retrieveProductByUserId(int id) {
		List<Product> products = new ArrayList<>();

		String sql = "select * from "+ _table +" where user_id = ?";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// extract each field from rs for each record, map them to a Product object and
				// add them to the products arrayliost
				Product product = new Product();
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				product.setOffer_price(rs.getDouble("offer_price"));
				product.setPaid(rs.getDouble("paid"));
				product.setPaid_at(rs.getTimestamp("paid_at"));
				product.setUser_id(rs.getInt("user_id"));
				products.add(product);

			}
		} catch (SQLException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return products;
	}

}
