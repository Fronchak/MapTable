package util;

public class PairValue<K, V> {

	private K key;
	private V value;
	
	public PairValue(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "<" + key + ", " + value + ">";
	}
	
}
