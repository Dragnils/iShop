package net.devstudy.servlet;

import net.devstudy.model.ShopingCartItem;
import net.devstudy.model.ShoppingCart;
import net.devstudy.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/current-cart")
public class ShoppingCartServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmd = req.getParameter("cmd");
        if("clear".equals(cmd)){// вводим в браузере после ?cmd=clear
            SessionUtils.clearCurrentShoppingCart(req, resp);
        } else if("invalidate".equals(cmd)){// вводим в браузере после ?cmd=invalidate
            req.getSession().invalidate(); // очищаем текущую сессию, куки при этом остается не изменным , будет полезным для востановления сессии для куки
        } else if("add".equals(cmd)){ // вводим в браузере после ?cmd=add
            addProduct(req, resp); // добавляем рандомный продукт
        } else {
            sync(req, resp);
        }
        showShoppingCart(req, resp); // посмотреть состояние сессии на сервере
    }

    protected void showShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/shopping-cart.jsp").forward(req, resp); // передали управление в jsp
        /*if(SessionUtils.isCurrentShoppingCartCreated(req)) {
            resp.getWriter().println(SessionUtils.getCurrentShoppingCart(req)); // печатает в респонс текущее состояние корзины
        } else {
            resp.getWriter().println("ShoppingCart is null");
        }*/
    }

    protected void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // добавляем рандомный продукт
        ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(req); // получаем текущую корзину
        Random r = new Random();
        shoppingCart.addProduct(r.nextInt(2), r.nextInt(1)+1); // добавляем какой то продукт в нашу корзину
    }

    //синхронизация куки и сессии
    protected void sync(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!SessionUtils.isCurrentShoppingCartCreated(req)) { //если в текущей сессии нету корзины
            Cookie cookie = SessionUtils.findShoppingCartCookie(req);// находим соответсвующую куки findShoppingCartCookie
            if(cookie != null) {
                ShoppingCart shoppingCart = shoppingCartFromString(cookie.getValue());// мы восстонавливаем состояние корзины из куки, с помощью метода десирилизации
                SessionUtils.setCurrentShoppingCart(req, shoppingCart); // устанавливаем состояние корзины в нашу сессию
            }
        } else {// иначе если в нашей сессии есть корзина
            ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(req); // мы получаем нашу корзину
            String cookieValue = shoppingCartToString(shoppingCart); // сериализуем в куки стринг
            SessionUtils.updateCurrentShoppingCartCookie(cookieValue, resp);// обновляем текущую куки, через классы SessionUtils затем WebUtils
        }
    }
    //серилизация
    protected String shoppingCartToString(ShoppingCart shoppingCart) {
        StringBuilder res = new StringBuilder();
        for (ShopingCartItem shoppingCartItem : shoppingCart.getItems()) {
            res.append(shoppingCartItem.getIdProduct()).append("-").append(shoppingCartItem.getCount()).append("|");
        }
        if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    //десерилизация
    protected ShoppingCart shoppingCartFromString(String cookieValue) {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = cookieValue.split("\\|");
        for (String item : items) {
            String data[] = item.split("-");
            try {
                int idProduct = Integer.parseInt(data[0]);
                int count = Integer.parseInt(data[1]);
                shoppingCart.addProduct(idProduct, count);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return shoppingCart;
    }
}
