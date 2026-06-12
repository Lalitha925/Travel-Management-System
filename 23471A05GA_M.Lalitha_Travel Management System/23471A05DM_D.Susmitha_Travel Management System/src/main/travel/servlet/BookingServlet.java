package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDAO;

public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int packageId =
                Integer.parseInt(request.getParameter("packageId"));

        String travelDate =
                request.getParameter("travelDate");

        int numPeople =
                Integer.parseInt(request.getParameter("numPeople"));

        int userId = 1;

        double totalPrice = 10000 * numPeople;

        BookingDAO dao = new BookingDAO();

        boolean status =
                dao.addBooking(userId,
                               packageId,
                               travelDate,
                               numPeople,
                               totalPrice);

        if(status) {
            response.getWriter().println(
                    "<h2>Booking Successful</h2>");
        } else {
            response.getWriter().println(
                    "<h2>Booking Failed</h2>");
        }
    }
}