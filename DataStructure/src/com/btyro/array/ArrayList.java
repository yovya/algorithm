package com.btyro.array;

import java.awt.print.Printable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.lang.System;

public class ArrayList implements List<Integer> {

	private static final int INITIAL_COUNT = 3;
	private int[] arrs;
	//当前数组中的总数
	private int count;
//	//当前指向的索引值
//	private int index;
	
	public ArrayList() {
		this.arrs = new int[ArrayList.INITIAL_COUNT];
		count = 0;
//		index = 0;
	}
	
	
	@Override
	public int size() {
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Integer t) {
		for (int i=0; i<this.count; i++) {
			if (this.arrs[i] == t) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(Integer t) {
		checkrange();
		this.count ++;
		this.arrs[this.count-1] = t;
//		index ++;
	
	}

	@Override
	public Integer get(int index) {
		checkExists(index);
		return this.arrs[index];
	}

	@Override
	public Integer set(int index, Integer t) {
		checkExists(index);
		int val = this.arrs[index];
		this.arrs[index] = t;
		return val;
	}

	@Override
	public void add(int index, Integer t) {
		checkrange();
		checkExists(index);
		System.arraycopy(this.arrs, index, this.arrs, index+1, count-index);
		this.arrs[index] = t;
//		index ++;
		count ++;
	}

	@Override
	public Integer remove(int index) {
		checkExists(index);
		int val = this.arrs[index];
		if (index != this.count - 1) {
			System.arraycopy(this.arrs, index+1, this.arrs, index, count-index-1);
		}
//		index--;
		count--;
		return val;
	}

	@Override
	public int indexof(Integer t) {
		for (int i=0;i<this.count;i++) {
			if (this.arrs[i] == t) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void clear() {
//		this.index = 0;
		this.count = 0;
	}

	private void checkrange() {
		if (this.arrs.length == count) {
			//扩容
			int[] newarr = new int[ArrayList.INITIAL_COUNT * 2];
			System.arraycopy(this.arrs, 0, newarr, 0, this.arrs.length);
			this.arrs = newarr;
		}
	}
	
	private void checkExists(int index) {
		if (index >= this.count || index < 0) {
			throw new RuntimeException("下标有误！要找的下标为：" + index);
		}
	}
	
	private void iterate() {
		System.out.print("[");
		for (int i = 0; i < this.count; i++) {
			if (i != this.count -1 ) {
				System.out.print( arrs[i] +",");
			} else {
				System.out.print(arrs[i]);
			}
		}
		System.out.print("]");
		System.out.println();
	}
	
	private static void print(Object val) {
		System.out.println(val);
	}

	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.iterate();
		print(list.size());
		print(list.isEmpty());
		print(list.set(0, 6));
		list.iterate();
		list.add(2,7);
		list.iterate();
		list.remove(0);
		list.iterate();
		print(list.contains(2));
		print(list.indexof(3));
		print(list.get(4));
		list.remove(4);
		list.iterate();
		list.clear();
		list.iterate();
		print(list.isEmpty());

		
		
	}
}
