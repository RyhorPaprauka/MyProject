package by.itacademy.popravko.bookShop.servlet;

import by.itacademy.popravko.bookShop.service.BookService;
import by.itacademy.popravko.bookShop.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/catalog")
public class Catalog extends HttpServlet {

    private BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookService.findAll());

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("catalog"))
                .forward(req, resp);
    }
}
