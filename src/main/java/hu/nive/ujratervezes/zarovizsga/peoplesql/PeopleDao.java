package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleDao {
    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select ip_address from people where first_name = ? and last_name=?");
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    String ip = rs.getString("ip_address");
                    return ip;
                }
                throw new IllegalArgumentException("No result");
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }


    }
}
