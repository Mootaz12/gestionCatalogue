package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionProduitImpl;
import dao.IGestionProduit;
import dao.entities.Produit;

/**
 * Servlet implementation class Controlleur
 */
@WebServlet("/controlleur")
public class Controlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */IGestionProduit gestion ;
	public void init(ServletConfig config) throws ServletException {
		 gestion = new GestionProduitImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action == null) {
            List<Produit> liste = gestion.getAllProducts();
            request.setAttribute("products", liste);
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("modifierprod")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantities = Integer.parseInt(request.getParameter("quantities"));
            
            request.setAttribute("name", name);
            request.setAttribute("prix", prix);
            request.setAttribute("quantities", quantities);
            request.setAttribute("id", id);
            request.getRequestDispatcher("index3.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("ajouterprod")) {
            request.getRequestDispatcher("ajout.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("rechercher")) {
            String mc = request.getParameter("mc");
            request.setAttribute("products", gestion.getProductsBMC(mc));
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("supprimer")) {
            int id = Integer.parseInt(request.getParameter("id"));
            gestion.deleteProduct(id);
            request.setAttribute("products", gestion.getAllProducts());
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("ajout")) {
            Produit produit = new Produit();
            produit.setNom(request.getParameter("name"));
            produit.setPrix(Double.parseDouble(request.getParameter("prix")));
            produit.setQuantite(Integer.parseInt(request.getParameter("quantities")));
            
            gestion.addProduct(produit);
            request.setAttribute("products", gestion.getAllProducts());
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("modifier")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int quantities = Integer.parseInt(request.getParameter("quantities"));
            double prix = Double.parseDouble(request.getParameter("prix"));
            
            Produit produit = new Produit(id, name, prix, quantities);
            gestion.updateProduct(produit) ;
            request.setAttribute("products", gestion.getAllProducts());
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
