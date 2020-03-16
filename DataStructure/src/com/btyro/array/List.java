package com.btyro.array;

public interface List<T> {

	int size();
	boolean isEmpty();
	boolean contains(T t);
	void add(T t);
	T get(int index);
	T set(int index, T t);
	void add(int index, T t);
	T remove(int index);
	int indexof(T t);
	void clear();
}
