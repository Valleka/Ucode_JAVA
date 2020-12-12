package world.ucode;

import world.ucode.CartPackage.Cart;
import world.ucode.logic.PixelizateImage;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class ServletPixel extends HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Part filePart = request.getPart("file");
        PixelizateImage pix = new PixelizateImage();
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = pix.toPixel(filePart.getInputStream());

        if (fileContent != null) {
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[2400];
            int count = 0;
            while ((count = fileContent.read(buffer)) >= 0) {
                response.getOutputStream().write(buffer);
            }
        }
        else {
            response.getWriter().println("Your use bad img");
        }
        System.out.println("Ok");
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        HttpSession session = request.getSession();

        //проверка на авторизацию пользователя по сессии (таймаут сессии 30 мин, после этого сессия удаляется), идентификация в дальнейшем идет по кукисам

//        String user = (String)session.getAttribute("current_user");
//
//        if(user == null) {
//            //response для анонимного пользователя
//            //авторизация
//            //регистрация
//            //session.setAttribute("current_user, ID);
//        } else {
//            //response для авторизованного пользователя
//        }

//        Cart cart = (Cart)session.getAttribute("cart"); //получаем объект Корзина из сессии
//
//        //получаем параметры из урла имя и количество
//        String name = request.getParameter("name");
//        int quantity = Integer.parseInt(request.getParameter("quantity")); // parseInt преобразовывает строчную ф-ю getParameter в значение инт
//
//        //если корзина еще не создавалась, то мы ее создаем
//        if(cart == null) {
//            cart = new Cart();
//            cart.setName(name);
//            cart.setQuantity(quantity);
//        }
//
//        session.setAttribute("cart", cart); //записываем в сессию новый атрибут Корзина

        //при срабатывании урла перекинем пользователя в jsp-файл с данными корзины, данные корзины будем прописывать в самом урле
        //getServletContext().getRequestDispatcher("/showCart.jsp").forward(request, response);



//        Integer count = (Integer) session.getAttribute("count");
//
//        //если пользователь зашел впервые, устанавливаем значение не ноль, а 1
//        if(count == null) {
//            session.setAttribute("count", 1);
//            //count = 1;
//        } else {
//            session.setAttribute("count", count + 1);
//        }

        //session.setAttribute("count", ); //указываем атрибуты

//          String fileName = request.getParameter("file");
//        String surname = request.getParameter("surname");


//        PrintWriter pw = response.getWriter();

//        pw.println("<html>");
//        pw.println("<h1>Your count, " + count + "</h1>");
//        //pw.println("<h1>Hello, " + name + " " + surname + "</h1>");
//        pw.println("</html>");

        // так мы перенаправляем пользователя на нужную страницу (внутреннюю или внешнюю) методом редиррект 301 или 302
        //response.sendRedirect("/pixelizator_war/pixelJSP.jsp");

        //так перенаправляем пользователе только на внутреннюю страницу методом Форвард
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pixelJSP.jsp");
        dispatcher.forward(request, response);

    }
}
