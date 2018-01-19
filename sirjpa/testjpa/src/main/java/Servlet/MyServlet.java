package Servlet;
import domain.Opower;
import service.OpowerDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="mytest",
        urlPatterns={"/myurl"})
public class MyServlet extends HttpServlet {

    OpowerDAO daop;
    @Override
    public void init() throws ServletException {
        super.init();
        daop = new OpowerDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Opower> opowerList = daop.readAll();

        PrintWriter p = new PrintWriter(resp.getOutputStream());
        for (Opower o: opowerList){
            p.println("<HTML>\n<BODY>\n" +
                    "<UL>\n" +
                    " <LI>Nom: " +o.getNom() +"<BR>"+
                    " <LI>Prenom: "
                    + o.getPrenom()+"<BR>"+
                    " <LI>Age: "
                    + o.getAge()+"<BR>"+
                    "</UL>\n" +
                            "</BODY></HTML>");
        }

        p.flush();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}

