package eus.uni.dam;

import java.util.Collection;

public interface ProduktuaDao {

	public Collection<Produktua> getProduktuak();
	
    public void hasieran();

	public Collection<Produktua> findAll() ;

	public void insert(Produktua produktua);

	public void edit(Produktua produktua);
	
	public void delete(long id) ;
}