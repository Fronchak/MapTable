package application;

import dataStructure.MapTable;
import exception.DSException;
import service.HashCodeServiceDjb2;

public class ProgramMapTable {

	public static void main(String[] args) {
		try {
			MapTable map = new MapTable(new HashCodeServiceDjb2());

			map.put("Gmack", "Gmack");
			map.put("Fronchak", "Fronchak");
			map.put("Claudia", "Claudia");
			map.put("Gabriel", "Gabriel");
			map.put("Alice", "Alice");
			map.put("Pedro", "Pedro");
			map.put("João", "João");
			map.put("Guilherme", "Guilherme");
			map.put("Ana", "Amn");
			map.put("Enzo", "Enzo");
			map.put("Claudio", "Cludio");
			map.put("Maria", "Maria");
			map.put("Carlos", "Carlos");
			System.out.println(map);
			System.out.println(map.get("Gabriel"));
			System.out.println(map.get("Enzo"));

		}
		catch(DSException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
