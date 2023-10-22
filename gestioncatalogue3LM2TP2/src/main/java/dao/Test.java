package dao;

import java.sql.Connection;

import dao.entities.Produit;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Connection cx1=SingletonConnection.getInstance();
		Connection cx2=SingletonConnection.getInstance();
		Connection cx3=SingletonConnection.getInstance();
		System.out.println(cx1+"\n"+cx2+"\n"+cx3);*/
		IGestionProduit gestion=new GestionProduitImpl();
		/*gestion.addProduct(new Produit("pc portable", 2000, 5));
		gestion.addProduct(new Produit("imprimante", 500, 15));*/
		System.out.println(gestion.getAllProducts());

	}

}
