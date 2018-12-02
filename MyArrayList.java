/*
 * COMP 352 - Assignment 2
 * @author: Mohanad Arafe & Hambrsoom Baboyan
 * Student ID: 40042922 & 40054395
 * Date: October 24, 2018 (with permission from Dr.Aiman Hanna)
 * --------------- Array List ----------------
 * In this part of the assignment, we must implement methods
 * from the List interface & create a functional array list.
 */

import java.util.*;
public class MyArrayList <T> implements List{

	private T[] arr;
	private int size;
	private int ctr;

	public MyArrayList(){
		size = 100;
		arr = (T[]) new Object[size];
		ctr = 0;
	}

	public int size(){
		return ctr;
	}

	public T[] resize(){
		double capacity = (double)ctr/size * 100;
		//double array size
		if(capacity >= 75){
			size = size * 2;
			T[] newArray = (T[]) new Object[size];
			for(int i = 0; i < arr.length; i++){
				if(arr[i] != null){
					newArray[i] = arr[i];
				}
			}
			arr = newArray;
			return arr;
		}
		//half the size
		if(capacity <= 25){
			size = size/2;
			T[] newArray = (T[]) new Object[size];
			for(int i = 0; i < arr.length; i++){
				if(arr[i] != null){
					newArray[i] = arr[i];
				}
			}
			arr = newArray;
			return arr;
		}
		return null;
	}

	public T get(int index) {
		return arr[index];
	}

	/**
	 *@param obj Object to add in array
	*/
	public boolean add(Object obj){
		T value = (T) obj;
		arr[ctr] = value;
		ctr++;
		arr = resize();
		return true;
	}

	/**
	 *@param index index to insert in array
	 *@param obj object to insert in array
	*/
	public void add(int index, Object element) {
		T value = (T) element;
		if (index >=0 && index <=ctr) {
			for (int i = size-1; i>=index;i--) {
				if (arr[i]!=null) {
					arr[i+1]= arr[i];
				}
			}
			arr[index]=value;
			ctr++;
			resize();
		}
		else {
			System.out.println("Out of Boundary add");
		}
	}


	public void clear(){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != null){
				arr[i] = null;
				ctr--;
			}
		}
	}

	public T remove(int index){
		T storedElement = arr[index];
		if(index == ctr-1){
			arr[index] = null;
			return storedElement;
		}
		if(index <= ctr){
			arr[index] = null;
			for(int i = index; i < ctr-1; i++){
				arr[i] = arr[i+1];
			}
			arr[ctr-1] = null;
			ctr--;
			arr = resize();
			return storedElement;
		}else{
			System.out.println("Array out of boundary");
			return null;
		}
	}	
	
	public boolean remove(Object obj){
		T value = (T) obj;
		int index = 0;
		for(int i = 0; i < ctr; i++){
			if(arr[i] == value){
				remove(i);
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String storage ="";
		for (int i=0; i<=ctr-1;i++) {
			storage += arr[i]+" ";
		}
		return storage;
	}


//------------------DRIVER TEST-----------------------

	public static void main(String[] args){
		MyArrayList <String> arr = new MyArrayList<String>();
		arr.add("a");
		arr.add(0, "b");
		arr.remove("b");
		arr.add("c");
		arr.add("e");
		arr.remove("c");
		
		System.out.println(arr.toString());
	}

//-----------------UNSUPPORTED------------------------

@Override
		public boolean addAll(Collection arg0) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(int arg0, Collection arg1) {
			throw new UnsupportedOperationException();
		}



		@Override
		public boolean containsAll(Collection arg0) {
			throw new UnsupportedOperationException();
		}


		@Override
		public int indexOf(Object arg0) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isEmpty() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterator iterator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int lastIndexOf(Object arg0) {
			throw new UnsupportedOperationException();
		}

		@Override
		public ListIterator listIterator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public ListIterator listIterator(int arg0) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean contains(Object o){
			throw new UnsupportedOperationException();
		}	

		@Override
		public boolean removeAll(Collection arg0) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection arg0) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object set(int arg0, Object arg1) {
			throw new UnsupportedOperationException();
		}


		@Override
		public List subList(int arg0, int arg1) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object[] toArray() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object[] toArray(Object[] arg0) {
			throw new UnsupportedOperationException();
		}


}
