package com.pmp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pmp.services.DealerService;
import com.pmp.sql.DatabaseConnector;

@WebServlet("/dealer")
public class DealerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection;
	DealerService dealerService = new DealerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");
		dbconnection = DatabaseConnector.getDBConnection();

		boolean isUserValid = dealerService.isUserValid(userId, password, dbconnection);
		if (isUserValid) {
			request.getSession().setAttribute("userId", userId);
			request.getSession().setAttribute("csrfToken", generateCSRFToken());
			String sessionid = request.getSession().getId();
			response.setHeader("Set-Cookie", "JSESSIONID=" + sessionid + ";");
			doGet(request, response);
		} else {
			request.setAttribute("error", "Invalid credientials");
			request.getRequestDispatcher("jsp/home-page.jsp").forward(request, response);

		}
	}

	public static String generateCSRFToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}

}
