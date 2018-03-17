package com.pmp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.pmp.elements.Product;
import com.pmp.services.CategoryService;
import com.pmp.services.DealerService;
import com.pmp.sql.DatabaseConnector;

@WebServlet("/dealer")
@MultipartConfig
public class DealerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection = DatabaseConnector.getDBConnection();
	DealerService dealerService = new DealerService(dbconnection);
	CategoryService categoryService = new CategoryService(dbconnection);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("addProductSubmit") != null) {
			dealerService.addNewProduct(mapProductDetails(request));
			doGet(request, response);
		} else if (request.getParameter("addCategorySubmit") != null) {
			dealerService.addNewCategory(request.getParameter("categoryName"));
			doGet(request, response);
		} else {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String password = request.getParameter("password");

			boolean isDealerValid = dealerService.isDealerValid(userId, password);

			if (isDealerValid) {
				request.getSession().setAttribute("userId", userId);
				// request.getSession().setAttribute("csrfToken", generateCSRFToken());
				// String sessionid = request.getSession().getId();
				response.setHeader("Set-Cookie", "userId=" + userId + ";");
				doGet(request, response);
			} else {
				request.setAttribute("error", "Invalid credientials");
				request.getRequestDispatcher("jsp/home-page.jsp").forward(request, response);
			}
		}
	}

	private Product mapProductDetails(HttpServletRequest request) {
		try {
			Product product = new Product();
			product.setProductName(request.getParameter("productName"));
			product.setProductDescription(request.getParameter("productDescription"));
			product.setDealerId((int) request.getSession(false).getAttribute("userId"));
			product.setCategoryId(categoryService.getCategoryIdByCategoryName(request.getParameter("productCategory")));
			product.setCost(Float.parseFloat(request.getParameter("productCost")));
			product.setStockQuantity(Integer.parseInt(request.getParameter("productQuantity")));

			Part filePart = request.getPart("productImage");
			String fileName = filePart.getSubmittedFileName();
			System.out.println(fileName);
			product.setProductImage(fileName);

			return product;
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String generateCSRFToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}

}
