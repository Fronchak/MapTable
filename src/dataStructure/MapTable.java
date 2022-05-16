package dataStructure;

import exception.DSException;
import service.HashCodeService;
import util.Math;
import util.PairValue;

public class MapTable {

	private PairValue[] table;
	private HashCodeService hashCode;
	private int size;
	
	private static final int DEFAULT_START_SIZE = 4;
	private static final double DEFAULT_FATOR_DE_CARGA = 0.75;
	
	public MapTable(HashCodeService hashCode) throws DSException {
		this(hashCode, DEFAULT_START_SIZE);
	}
	
	public MapTable(HashCodeService hashCode, int size) throws DSException {
		if(size < 1) { throw new DSException ("Invalid input arguments!"); }
		this.table = new PairValue[Math.getNextPrimeNumer(size)];
		this.hashCode = hashCode;
		hashCode.setSize(table.length);
		this.size = 0;
	}
	
	public void put(String key, String value) throws DSException {
		checkInputsParameters(key, value);
		int position = getPositionForAdd(key);
		this.table[position] = new PairValue(key, value);
		this.size++;
		ResizeIfNecessary();
	}
	
	private void checkInputsParameters(String key, String value) throws DSException {
		checkIfNullOrEmpty(key);
		checkIfNullOrEmpty(value);
	}
	
	private void checkIfNullOrEmpty(String inputValue) throws DSException {
		if (inputValue == null || inputValue.equals("")) {
			throw new DSException("Invalid input parameters!");
		}
	}
	
	private int getPositionForAdd(String key) {
		int sondagem = 0;
		int tableSize = this.table.length;
		int hash = 0;
		while(sondagem < tableSize) {
			hash = (hashCode(key) + sondagem) % tableSize;
			PairValue pair = this.table[hash];
			if(pair == null || pair.getKey().equals(key)) {
				break;
			}
			sondagem++;
		}
		return hash;
	}
	
	private int hashCode(String key) {
		return this.hashCode.hashCode(key);
	}
	
	private void ResizeIfNecessary() {
		if((this.size / this.table.length) >= DEFAULT_FATOR_DE_CARGA) {
			Resize();
		}
	}
	
	private void Resize() {
		PairValue[] pairValues = this.table;
		int newSize = Math.getNextPrimeNumer(this.table.length);
		this.table = new PairValue[newSize];
		this.size = 0;
		this.hashCode.setSize(newSize);
		putPairsIntoNewArray(pairValues);
	}
	
	private void putPairsIntoNewArray(PairValue[] pair) {
		for(PairValue p : pair) {
			try {
				put(p.getKey(), p.getValue());
			}
			catch(DSException e) {
				
			}
		}
	}
	
	public String get(String key) {
		int hash = hashCode(key);
		int limite = table.length;
		PairValue pair = null;
		for(int i = hash; i < limite; i++) {
			pair = table[i];
			if(pair == null) { return null; }
			if(pair.getKey().equals(key)) { return pair.getValue(); }
			if(i == table.length - 1) { 
				i = -1; 
				limite = hash;
			}
		}
		return null;
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.table.length; i++) {
			sb = sb.append("[ " + i + ", " + table[i] + ", " + getHashCode(i) + " ]\n");
		}
		return sb.toString();
	}
	
	private String getHashCode(int i) {
		PairValue pair = this.table[i];
		return pair == null ? "" : "" + hashCode.hashCode(pair.getKey());
	}
}
