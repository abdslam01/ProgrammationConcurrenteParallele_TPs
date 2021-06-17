package main;

import java.util.ArrayList;

public class MdseStock {
	private int maxStock;
	private ArrayList<MdseObject> stock;
	
	public MdseStock(int mdseMax) {
		maxStock=mdseMax;
		stock=new ArrayList<>();
	}
	
	public MdseStock(ArrayList<MdseObject> stock, int mdseMax) {
		maxStock=mdseMax;
		this.stock=stock;
	}
	
	public void pushToStock(MdseObject mdseObject) {
		stock.add(mdseObject);
	}
	
	public MdseObject popFromStock() {
		return stock.remove(0);
	}
	
	public MdseObject getLastInStock() {
		return stock.get(0);
	}
	
	public boolean stockEstVide() {
		return stock.isEmpty();
	}
	
	public int poidsDeStock() {
		int p=0;
		for(MdseObject m: stock)
			p+=m.getPoids();
		return p;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

	@Override
	public String toString() {
		return "Stock " + stock;
	}
}
