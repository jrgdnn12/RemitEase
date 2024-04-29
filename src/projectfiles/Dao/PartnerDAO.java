package projectfiles.Dao;

import java.sql.SQLException;

import projectfiles.model.Partner;

public interface PartnerDAO {
    /**
     * Adds a new partner object to the database. 
     * see {@link PartnerDaoImpl#addPartner(Partner) addPartner(Partner)}
     * @param partner
     * @throws SQLException
     */
	void addPartner(Partner partner) throws SQLException;  // Now correctly declaring the exception

    /**
     * Partner method for retrieving a {@link Partner} object by their {@link Partner#getCountry() Country}.
     * See {@link PartnerDAOImpl#getPartnerById(String) getPartnerById(String)}
     * @param Country The ID of the Partner to retrieve.
     * @return The Partner object if found, otherwise null.
     */
    Partner getPartnerById(String Country) throws SQLException;

    /**
     * Update the details of a partner in the Partner database. 
     * See {@link PartnerDAOImpl#updatePartner(Partner) updatePartner(Partner)}
     * @param partner
     * @throws SQLException
     */
    void updatePartner(Partner partner) throws SQLException;
}
