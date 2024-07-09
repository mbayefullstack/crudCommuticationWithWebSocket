package com.mbayefullstack.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbayefullstack.dao.ProductDAO;
import com.mbayefullstack.models.Product;
import com.mbayefullstack.websocket.ProductWebSocketEndpoint;

@WebServlet("/products/add")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");
        String stockStr = request.getParameter("stock");

        System.out.println("Received: name=" + name + ", price=" + priceStr + ", stock=" + stockStr);

        try {
            double price = Double.parseDouble(priceStr);
            int stock = Integer.parseInt(stockStr);

            Product newProduct = new Product();
            newProduct.setName(name);
            newProduct.setPrice(price);
            newProduct.setStock(stock);

            productDAO.addProduct(newProduct);

            String message = "New product added: " + newProduct.getName();
            ProductWebSocketEndpoint.broadcast(message);

            response.sendRedirect(request.getContextPath() + "/products");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/WEB-INF/jsp/error.jsp");
        }
    }
}
