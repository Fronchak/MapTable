package dataStructure;

import exception.DSException;
import service.HashCodeService;
import util.PairValue;
import util.Math;

public class MapTable {

	private PairValue[] table;
	private HashCodeService hashCode;
	private int size;
	
	private static final int DEFAULT_START_SIZE = 4;
	
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
		int hash;
		while(sondagem < tableSize) {
			hash = (hashCode(key) + sondagem) % tableSize;
			PairValue pair = this.table[hash];
			if(pair == null || pair.getKey().equals(key)) {
				return hash;
			}
			sondagem++;
		}
		
		return 0;
	}
	
	private int hashCode(String key) {
		return this.hashCode.hashCode(key);
	}
}
