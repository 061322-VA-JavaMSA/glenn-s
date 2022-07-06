/**
 * 
 */
package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column( columnDefinition = "NUMERIC(19,2)" )
	private double amount;
	
	@Column 
	private Timestamp  submitted;
	
	@Column
 	private Timestamp  resolved;
	
	@Column
	private String receipt;

	@ManyToOne 
	@JoinColumn(name = "author_id")	
	private User author;
	
	@ManyToOne 
	@JoinColumn(name = "resolver_id")		
	private User resolver;	

	@ManyToOne 
	@JoinColumn(name = "reim_status_id")	
	private ReimbursementStatus  reims_tatus;
	
	@ManyToOne 
	@JoinColumn(name = "reimb_type_id")		
	private ReimbursementType  reim_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp  getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp  submitted) {
		this.submitted = submitted;
	}

	public Timestamp  getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp  resolved) {
		this.resolved = resolved;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

//	public User getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(User author) {
//		this.author = author;
//	}
//
//	public User getResolver() {
//		return resolver;
//	}
//
//	public void setResolver(User resolver) {
//		this.resolver = resolver;
//	}
//
//	public ReimbursementStatus getReims_tatus() {
//		return reims_tatus;
//	}
//
//	public void setReims_tatus(ReimbursementStatus reims_tatus) {
//		this.reims_tatus = reims_tatus;
//	}
//
//	public ReimbursementType getReim_type() {
//		return reim_type;
//	}
//
//	public void setReim_type(ReimbursementType reim_type) {
//		this.reim_type = reim_type;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, receipt, resolved, submitted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && id == other.id
				&& Objects.equals(receipt, other.receipt) && Objects.equals(resolved, other.resolved)
				&& Objects.equals(submitted, other.submitted);
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", receipt=" + receipt + "]";
	}
	
}
