package application;

import dataStructure.MapTable;
import exception.DSException;
import service.HashCodeServiceDjb2;

public class ProgramMapTable {

	public static void main(String[] args) {
		try {
			MapTable map = new MapTable(new HashCodeServiceDjb2());
			map.put("Alice", "Alice");
			map.put("Gmack", "Gmack");
			map.put("Fronchak", "Fronchak");
			map.put("Claudia", "Claudia");
			map.put("Gabriel", "Gabriel");
		}
		catch(DSException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
