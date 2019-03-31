package by.itacademy.popravko.bookShop.servlet;

import by.itacademy.popravko.bookShop.dto.LoginDto;
import by.itacademy.popravko.bookShop.service.LoginService;
import by.itacademy.popravko.bookShop.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = LoginService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<LoginDto> user = loginService.login(username, password);
        if (user.isPresent()) {
            req.getSession().setAttribute("user", user.get());
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect(String.format("/login?username=%s&error=true", username));
        }
    }
}
