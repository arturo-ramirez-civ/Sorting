package Project_1;

public class SelectionSort extends AbstractSort {
	
	//Class attributes
	public int[] array;
	public int elements;
	public int count = 0;
	public long startTime;
	public long endTime;
	
	//Constructor
	public SelectionSort(int max) {
		//Create array
		this.array = new int[max];
		//No elements yet
		this.elements = 0;
	}
	
	//Put element into array
	public void insert(int value) {
		//Insert element
		array[elements] = value;
		//increment size
		elements++;	
	}
	
	//Display array contents
	public void display() {
		//For each element
		for (int j = 0; j< elements; j++) {
			//Display element
			System.out.println(array[j] + " ");
		}
		System.out.println(" ");
	}	
	
	//Verify correctness of sorting
	public boolean notSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] <= array[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void sort(int[] array) throws UnsortedException {
		
		int out;
		int in;
		int min;
		
		//Call method to start nanosecond timer and counter
		startSort();
		
		//Outer loop
		for(out = 0; out < elements - 1; out++) {
			//Counter
			incrementCount();
			//Minimum
			min = out;
			//Inner loop
			for (in = out + 1; in < elements; in++) {
				//Counter
				incrementCount();
				//If minimum is greater
				if (array[in] < array[min]) {
					//Set new minimum
					min = in;
				}
			}//End of inner loop
			//Swap values
			swap(out, min);
		}// End of out loop	
		
		//Call method to end nanosecond timer
		endSort();	
		
		//method to verify correctness
		if (notSorted(array)) {
			throw new UnsortedException();
		}
		
	}//End of sort
	
	//Helper function to swap values
	public void swap(int one, int two) {
		//Counter
		incrementCount();
		//Swapping values
		int temp = array[one];
		array[one] = array[two];
		array[two] = temp;		
	}
	
	public void startSort() {		
		count = 0;
		startTime = System.nanoTime();	
	}
	
	public void endSort() {
		endTime = System.nanoTime();		
	}

	public void incrementCount() {
		count++;
	}
	
	@Override
	public int getCount() {
		return count;
	}
	
	@Override
	public long getTime() {
		return endTime - startTime;
	}	
}// End of SelectionSort Class
