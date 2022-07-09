package com.revature.daos;

import com.revature.models.ReimbursementType;

public interface ReimbursementTypeDAO {
	ReimbursementType getReimbursementTypeById(int id);
	ReimbursementType getByName(String reimb_type);
}
