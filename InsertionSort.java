package Project_1;

public class InsertionSort extends AbstractSort {
	
	//Class attributes
	public int[] array;
	public int elements;
	public int count = 0;
	public long startTime;
	public long endTime;
	
	//Constructor
	public InsertionSort(int max) {
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
		//Call method to start nanosecond timer and counter
		startSort();
		
		//Out is dividing line
		for(out = 1; out < elements; out++) {
			//Counter
			incrementCount();
			//Remove element
			int temp = array[out];
			//Start shift at out
			in = out;
			//Loop while one is smaller
			while (in > 0 && array[in - 1] >= temp) {
				//Counter
				incrementCount();
				//Shift element right
				array[in] = array[in - 1];
				//Left one place
				--in;
			}//End of while loop
		array[in] = temp;
		}//End of for loop
		
		//Call method to end nanosecond timer
		endSort();	
		
		//method to verify correctness
		if (notSorted(array)) {
			throw new UnsortedException();
		}
				
	}//End of sort
	
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
}// End of InsertionSort class
