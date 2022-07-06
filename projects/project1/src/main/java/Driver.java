import java.util.ArrayList;
import java.util.List;

import com.revature.dto.UserDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

 
public class Driver {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReimbursementService rs = new ReimbursementService();
		List<Reimbursement> reim = rs.getReimburse();
//		UserService us = new UserService();
//		List<User> users = us.getUsers(); 
		System.out.println(reim.toString());
 	}

}
