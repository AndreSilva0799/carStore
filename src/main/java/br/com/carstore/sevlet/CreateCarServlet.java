package br.com.carstore.sevlet;

import br.com.carstore.dao.CarDAO;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String carName = request.getParameter("carName");

        CarDAO carDao = new CarDAO();

        Car car = new Car(carName);


        car.setName(carName);

        carDao.createCar(car);


        System.out.println("o nome do carro é: " + carName);
        request.getRequestDispatcher("index.html").forward(request,resp);


    }
}
