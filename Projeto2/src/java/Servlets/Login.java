package Servlets;

import Configurations.ConfigurationsMySQL;
import Database.Database;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igorv
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    private final Database db = new Database(new ConfigurationsMySQL());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta charset=\"utf-8\" />");
        out.println("       <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("       <title> - ALPHA - </title>");
        out.println("       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("       <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style.css\" />");
        out.println("       <script src=\"main.js\"></script>");
        out.println("   </head>");

        out.println("   <body>");
        out.println("       <div class=\"background\">");
        out.println("          <a href=\"/Projeto2/Cadastro\"> <div <div class=\"right-menu\">Cadastrar</div> </a>");
        out.println("           <a href=\"/Projeto2/Publicacao\"> <div class=\"right-menu\">Publicar textos</div> </a>");
        out.println("           <a href=\"/Projeto2/Busca\"> <div class=\"right-menu\">Buscar </div> </a>");
        out.println("           <a href=\"/Projeto2/Main\"> <div class=\"right-menu\">Home </div> </a>");
        out.println("           <div class = \"icon\"></div>");
        out.println("           <div class=\"left-menu\"><b>Alpha</b> by Pixelarity</div>");
        out.println("           <p class = \"fontesup1\">Textos diversos</p>");
        out.println("           <table class = \"tabela-botao\">");
        out.println("               <tr>");
        out.println("                   <td class = \"firstelement\"><a href = \"/Projeto2/Login\"> Logar </a></td>");
        out.println("                   <td class = \"secondelement\"><a href = \"/Projeto2/Publicacao\"> Criar texto </a></td>");
        out.println("               </tr>");
        out.println("           </table>");
        out.println("       </div>");
        out.println("       <div class=\"central1\">");
        out.println("           <div class=\"header\">");
        out.println("               <h1>Login</h1>");
        out.println("               <br><br>");
        out.println("               <form action = \"/Projeto2/Login\" method = \"POST\"> <br>");
        out.println("               Usuario <br>");
        out.println("               <input type = \"text\" name = login value = \"\"> <br>");
        out.println("               Senha <br>");
        out.println("               <input type = \"text\" name = password value = \"\"><br><br>");
        out.println("               <input type = \"submit\" value = \"Entrar\"><br><br>");
        out.println("               <a href = \"/Projeto2/Cadastro\">Ainda não possui conta? Cadastre-se clicando aqui! </a>");
        out.println("           </div>");
        out.println("       </div>");
        out.println("   </body>");
        out.println("</html>");
            }
    
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
        String name = request.getParameter("login");
        String password = request.getParameter("password");
        ResultSet rs = null;        
                
    try (PrintWriter out = response.getWriter()) {
    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta charset=\"utf-8\" />");
            out.println("       <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println("       <title> - ALPHA - </title>");
            out.println("       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("       <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style.css\" />");
            out.println("       <script src=\"main.js\"></script>");
            out.println("   </head>");

            out.println("   <body>");
            out.println("       <div class=\"background\">");
            out.println("          <a href=\"/Projeto2/Cadastro\"> <div <div class=\"right-menu\">Cadastrar</div> </a>");
            out.println("           <a href=\"/Projeto2/Publicacao\"> <div class=\"right-menu\">Publicar textos</div> </a>");
            out.println("           <a href=\"/Projeto2/Busca\"> <div class=\"right-menu\">Buscar </div> </a>");
            out.println("           <a href=\"/Projeto2/Main\"> <div class=\"right-menu\">Home </div> </a>");
            out.println("           <div class = \"icon\"></div>");
            out.println("           <div class=\"left-menu\"><b>Alpha</b> by Pixelarity</div>");
            out.println("           <p class = \"fontesup1\">Textos diversos</p>");
            out.println("           <p class = \"fontesup2\">Bem vindo");
            out.println("           <table class = \"tabela-botao\">");
            out.println("               <tr>");
            out.println("                   <td class = \"firstelement\"><a href = \"/Projeto2/Login\"> Logar </a></td>");
            out.println("                   <td class = \"secondelement\"><a href = \"/Projeto2/Publicacao\"> Criar texto </a></td>");
            out.println("               </tr>");
            out.println("           </table>");
            if(name.equals("")){
            out.println("       <div class=\"central1\">");
            out.println("           <div class=\"header\">");
            out.println("               <br><br>");
            out.println("               Campo nome não pode ficar vazio!");
            out.println("               <br><br>");
            out.println("               <a href=\"/Projeto2/Login\">Voltar a pagina de login</a>");
            out.println("           </div>");
            out.println("       </div>");
            out.println("   </body>");
            out.println("</html>");
    }
    else if(password.equals("")){
            out.println("       <div class=\"central1\">");
            out.println("           <div class=\"header\">");
            out.println("               <br><br>");
            out.println("               Campo senha não pode ficar vazio!");
            out.println("               <br><br>");
            out.println("               <a href=\"/Projeto2/Login\">Voltar a pagina de cadastro</a>");
            out.println("           </div>");
            out.println("       </div>");
            out.println("   </body>");
            out.println("</html>");
        } 
    else{
        rs = this.db.query("SELECT user_name,user_password FROM users WHERE "
        +"user_name='"+name+"' AND user_password='"+password+"'");
    
    if (name != null && rs.isBeforeFirst()!=false) {
        out.println("       </div>");
        out.println("       <div class=\"central1\">");
        out.println("           <div class=\"header\">");
        request.getSession().setAttribute("login", name);
        out.println("               <h1>Login</h1>");
        out.println("               <br><br>");
        out.println("               <p>Usuário logado!<p>");
    }
    else{
        out.println("       </div>");
        out.println("       <div class=\"central1\">");
        out.println("           <div class=\"header\">");
        out.println("Usuário não encontrado!");
        out.println("<br><br>");
        out.println("<a href=\"/Projeto2/Login\">Voltar à página de login</a>");
    }
        out.println("           </div>");
        out.println("       </div>");
        out.println("   </body>");
        out.println("</html>");
    }
    }       catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
