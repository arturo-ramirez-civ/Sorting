package Project_1;

public abstract class AbstractSort {
	
	public abstract void sort(int[] array) throws UnsortedException;
	
	public abstract void startSort();
	
	public abstract void endSort();

	public abstract void incrementCount();
	
	abstract int getCount();
	
	abstract long getTime();	
}//End of AbstractSort Class
