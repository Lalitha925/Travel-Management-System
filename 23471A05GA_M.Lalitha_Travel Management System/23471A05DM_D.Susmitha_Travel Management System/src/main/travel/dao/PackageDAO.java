package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Package;

public class PackageDAO {

    public List<Package> getAllPackages() {

        List<Package> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM packages";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Package p = new Package();

                p.setPackageId(
                        rs.getInt("package_id"));

                p.setPackageName(
                        rs.getString("package_name"));

                p.setDestination(
                        rs.getString("destination"));

                p.setDurationDays(
                        rs.getInt("duration_days"));

                p.setDescription(
                        rs.getString("description"));

                p.setPrice(
                        rs.getBigDecimal("price"));

                list.add(p);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}