package service;

public class HashCodeServiceDjb2 implements HashCodeService{

	private int size;
	
	public HashCodeServiceDjb2() {
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int hashCode(Object obj) {
		String objString = obj.toString();
		Long hash = 5381L;
		for(int i = 0; i < objString.length(); i++) {
			hash = (hash * 33) + ((Character)objString.charAt(i)).hashCode();
		}
		return (int) (hash % size);
	}
	
	

}
