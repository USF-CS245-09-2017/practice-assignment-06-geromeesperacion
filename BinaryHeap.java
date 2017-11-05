/**
 * 
 * @author geromeesperacion
 *
 */

public class BinaryHeap {
	
	private int[] heap;
	private int size;
	
	//constructor
	public BinaryHeap() {
		this.heap = new int[10]; //arbitrary size - grow heap if needed
		this.size = 0;
	}
	
	/*
	 * grows the heap by making it twice the original size
	 */
	public void growHeap() {
		int[] newheap = new int[heap.length*2];
		System.arraycopy(this.heap, 0, newheap, 0, heap.length);
		this.heap = newheap;
	}
	
	/*
	 * swaps the index parameter with the parent
	 */
	public void swap(int index, int parent) {
		int temp = heap[index];
		heap[index] = heap[parent];
		heap[parent] = temp;	
	}
	
	/*
	 * returns the left child
	 */
	public int leftChild(int index) {
		return (index * 2) + 1;
	}
	
	/*
	 * returns the right child
	 */
	public int rightChild(int index) {
		return (index * 2) + 2;
	}
	
	/*
	 * returns the parent
	 */
	public int parent(int index) {
		return (index - 1) / 2;
	}
	
	/*
	 * adds an int instance to the priority queue
	 */
	public void add(int priority) {
		if(heap.length == size) {
			growHeap();
		}
		
		heap[size++] = priority;
		int index = size - 1;
		
		while(heap[index] < heap[parent(index)] && index > 0) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	/*
	 * prints the heap
	 */
	public String printheap() {
		String test = "";
		for(int i = 0; i < heap.length; i++) {
			test = test + heap[i] + " ";
		}
		
		return test;
		
	}
	
	/*
	 * removes the highest priority item from the priority queue
	 * throws an exception if the heap is empty
	 */	
	public int remove() throws Exception {
		if(size == 0) {
			throw new Exception("There is nothing to remove. The heap is empty.");
		}
		
		int priority = heap[0];
		heap[0] = heap[--size];
		siftdown(0);
		
		return priority;
		
	}
	
	/*
	 * iterates through the heap and swaps the lower item to the top
	 */
	private void siftdown(int pos) {
		if (leftChild(pos) < size) { 
			int child = leftChild(pos);
			
			if (rightChild(pos) < size && heap[rightChild(pos)] < heap[child]) {
				child = rightChild(pos);
			}
			
			if (heap[pos] > heap[child]) {
				swap(pos, child);
				siftdown(child);
			}
		}
		
	}
	
}
