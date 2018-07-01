import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@WebServlet("/inject")
public class injectionDependency extends HttpServlet {
    @Inject
    @QualifTest
    Eba myBeanTest;

    @Inject
    @QualifFirst
    Eba myBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(myBean.getValue());
        System.out.println(myBeanTest.getValue());
    }
}

interface Eba {
    String getValue();
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@interface QualifFirst {}

@QualifFirst
class MyBean implements Eba {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return "Its MyBean class";
    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@interface QualifTest {}

@QualifTest
class Test implements Eba {

    @Override
    public String getValue() {
        return "Its Test class";
    }
}
