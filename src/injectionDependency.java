import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import java.io.IOException;

@WebServlet("/inject")
public class injectionDependency extends HttpServlet {

    @Inject
    Test test;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("test.jsp");
        dispatcher.forward(req,resp);
    }
}

@RequestScoped
@Named
class Test {

    private String name = "owowowowowo";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
