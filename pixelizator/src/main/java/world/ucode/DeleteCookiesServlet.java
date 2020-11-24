package world.ucode;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //удалим какой то 1 куки
        Cookie cookie = new Cookie("some_id", "");
        cookie.setMaxAge(0); //говорим что этот куки хранится 0 сек

        //cookie.setMaxAge(-1); //удаляем куки при закрытии браузера

        response.addCookie(cookie);
    }
}
