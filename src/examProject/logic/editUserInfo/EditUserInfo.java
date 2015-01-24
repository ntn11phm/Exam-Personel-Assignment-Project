package examProject.logic.editUserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import examProject.dao.DbManipulator;
import examProject.transferObjects.HostTO;
import examProject.transferObjects.LoggedInUserTO;
import examProject.transferObjects.UpdateUserTransfere;

public class EditUserInfo {
	private LoggedInUserTO currentUser;
	private DbManipulator dbm;

	public EditUserInfo(DbManipulator dbm,LoggedInUserTO currentUser) {
		this.currentUser = currentUser;
		this.dbm = dbm;
	}
	
	public List<HostTO> getHosts() {
		String selectCommand = "SELECT first_name, last_name, civicnr, host_id FROM hosts ORDER BY last_name, first_name, civicnr;";
		List<HostTO> hostArray = new ArrayList<HostTO>();
		dbm.openDb();
		ResultSet rs = dbm.select(selectCommand);
		try {
			while (rs.next()) {
				hostArray.add(new HostTO(rs.getInt("host_id"), rs.getString("first_name"), rs.getString("last_name")));
			}
		} catch (SQLException e) {}
		dbm.closeDb();
		return hostArray;
	}

	public UpdateUserTransfere getHost(int host_id) {
		UpdateUserTransfere host = null;
		String selectCommand = "SELECT first_name, last_name, civicnr, address, zipcode, city, phone_nr, mobile_phone, email, is_active, is_admin FROM hosts, users WHERE host_id = '" + host_id + "' AND hosts.user_id = users.user_id;";
		dbm.openDb();
		ResultSet rs = dbm.select(selectCommand);
		try {
			while (rs.next()) {
				host = new UpdateUserTransfere(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("email"), rs.getString("city"), rs.getString("address"), rs.getString("mobile_phone"), rs.getString("phone_nr"), rs.getString("zipcode"), rs.getString("civicnr"), rs.getBoolean("is_active"), rs.getBoolean("is_admin"));
			}
		} catch (SQLException e) {}
		dbm.closeDb();
		return host;
	}
	
	public boolean updateHost(int host_id, UpdateUserTransfere hostData) {
		boolean result1 = false;
		boolean result2 = false;
		if (currentUser.isIs_admin())
			if (hostData.getEmail().equals(hostData.getRetypeEmail())) {
				String sqlCommand = "UPDATE hosts SET first_name = '" + hostData.getFirstName() +
						"', last_name = '" + hostData.getLastName() + "', address = '" + hostData.getAddress() +
						"', zipcode = '" + hostData.getZipCode() + "', city = '" + hostData.getCity() +
						"', civicnr = '" + hostData.getCivic() + "', phone_nr = '" + hostData.getPhoneNr() +
						"', mobile_phone = '" + hostData.getMobileNr() + "', email = '" + hostData.getEmail() +
						"', is_active = " + hostData.isActive() + " WHERE host_id = " + host_id + ";";
				dbm.openDb();
				result1 = dbm.update(sqlCommand);
				sqlCommand = "UPDATE users SET is_admin = " + hostData.isAdmin() + " WHERE user_id = (SELECT user_id FROM hosts WHERE host_id = " + host_id + ");";
				result2 = dbm.update(sqlCommand);
				dbm.closeDb();
			}
		return result1 && result2;
	}
}
