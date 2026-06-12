package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingDAO {

    public boolean addBooking(int userId,
                              int packageId,
                              String travelDate,
                              int numPeople,
                              double totalPrice) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
            "INSERT INTO bookings(user_id, package_id, travel_date, num_people, total_price) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, packageId);
            ps.setString(3, travelDate);
            ps.setInt(4, numPeople);
            ps.setDouble(5, totalPrice);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}