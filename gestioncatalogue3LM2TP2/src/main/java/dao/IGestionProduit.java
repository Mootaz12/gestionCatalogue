package dao;

import java.util.List;

import dao.entities.Produit;

public interface IGestionProduit {
	
	public void addProduct(Produit p);
	public void deleteProduct(int id);
	public void updateProduct(Produit p);
	public Produit getProduct(int id);
	public List<Produit>getAllProducts();
	public List<Produit> getProductsBMC(String mc);
	

}
