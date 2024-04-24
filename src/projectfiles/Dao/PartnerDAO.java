package projectfiles.Dao;

import java.sql.SQLException;

import projectfiles.model.Partner;

public interface PartnerDAO {
	void addPartner(Partner partner) throws SQLException;  // Now correctly declaring the exception
    Partner getPartnerById(String PartnerId) throws SQLException;
    void updatePartner(Partner partner) throws SQLException;
}
