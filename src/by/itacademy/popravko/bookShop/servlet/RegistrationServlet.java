package by.itacademy.popravko.bookShop.servlet;

import by.itacademy.popravko.bookShop.dto.NewUserDto;
import by.itacademy.popravko.bookShop.service.UserService;
import by.itacademy.popravko.bookShop.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        NewUserDto newUserDto = NewUserDto.builder()
                .login(login)
                .password(req.getParameter("password"))
                .realName(req.getParameter("name"))
                .mail(req.getParameter("mail"))
                .address(req.getParameter("address"))
                .phone(req.getParameter("phone"))
                .build();
        UserService.getInstance().registration(newUserDto);
        /*if ok*/
        resp.sendRedirect(String.format("/login?login=%s&success=true", login));
    }
}
