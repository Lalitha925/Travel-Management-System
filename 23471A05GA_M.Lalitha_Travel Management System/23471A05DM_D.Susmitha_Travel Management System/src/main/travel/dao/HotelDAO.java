package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Hotel;

public class HotelDAO {

    public List<Hotel> getAllHotels() {

        List<Hotel> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM hotels";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Hotel h = new Hotel();

                h.setHotelId(rs.getInt("hotel_id"));
                h.setHotelName(rs.getString("hotel_name"));
                h.setLocation(rs.getString("location"));
                h.setRating(rs.getDouble("rating"));
                h.setPricePerNight(rs.getDouble("price_per_night"));

                list.add(h);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}