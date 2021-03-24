package edu.mtc.egr283.sll;

/****************************************************************************
 * Class for handling the data in a <code>SLL</code>.
 * @author Jacob Vaught
 * @version 1.00 2021-02-25
 * Copyright (c) 2021 by William Sims. All rights reserved.
 **/

public class SLL<E> {

	private int length;
	private SLLNode<E> head;
	private SLLNode<E> tail;

	public static final String COLON_SPACE = ": ";
	public static final String NEW_LINE = "\n";

	/**
	 * Default Constructor
	 */
	public SLL() {
		this.length = 0;
		this.tail = new SLLNode<E>();
		this.head = new SLLNode<E>(null, this.tail);
	}// Ending bracket of constructor

	/**
	 * @return int <code>length</code>
	 */
	public int size() {
		return this.length;
	}// Ending bracket of method size

	/**
	 * @param int <code>position</code>
	 * @return E <code>nodeData</code>
	 */
	public E getDataAtPosition(int position) {
		return (this.find(position)).getNodeData();
	}// Ending bracket of method getDataAtPosition

	/**
	 * @param <code>newNodeData</code>
	 */
	public void addAtHead(E newNodeData) {
		SLLNode<E> newNode = new SLLNode<E>(newNodeData, null);
		this.addAfter(this.head, newNode);
	}// Ending bracket of method addAtHead

	/**
	 * @param <code>newNodeData</code>
	 * @param <code>position</code>
	 */
	public void add(E newNodeData, int position) {
		SLLNode<E> cursor = this.head;
		if(position > 0) {
			cursor = this.find(position - 1);
		}// Ending bracket of if
		this.addAfter(cursor, new SLLNode<E>(newNodeData, null));
	}// Ending bracket of method add

	/**
	 * @param position
	 * @return E data at a position
	 */
	public E remove(int position) {
		SLLNode<E> cursor = this.head;
		if(position > 0) {
			cursor = this.find(position - 1);
		}// Ending bracket of if

		SLLNode<E> target = cursor.getNext();
		cursor.setNext(target.getNext());
		--this.length;

		E rv = target.getNodeData();

		target.setNext(null);
		target.setNodeData(null);

		return rv;
	}// Ending bracket of method remove (int.)

	/**
	 * @param targetData
	 * @return data to be removed
	 */
	public E removeData(E targetData) {
		return this.remove(this.findIndex(targetData));
	}// Ending bracket of method removeData(E)

	/**
	 * @param newNodeData
	 * @param position
	 */
	public void setData(E newNodeData, int position) {
		(this.find(position)).setNodeData(newNodeData);
	}// Ending bracket of method setData

	/**
	 *simple Tostring method
	 * @return <code>String</code> 
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();

		SLLNode<E> cursor = this.head.getNext();
		int index = 0;

		while(cursor != tail) {
			sb.append(index + COLON_SPACE + cursor.getNodeData().toString() + NEW_LINE);
			cursor = cursor.getNext();
			++index;
		}// Ending bracket of while loop

		return sb.toString();
	}// Ending bracket of method toString
	
	//******************************************************************************************************************
	//******************************************************************************************************************

	/**
	 * @param currentNode
	 * @param newNode
	 */
	private void addAfter(SLLNode<E> currentNode, SLLNode<E> newNode) {
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		++this.length;
	}// Ending bracket of method addAfter

	/**
	 * @param targetData
	 * @return index(location) of specified data
	 */
	private int findIndex(E targetData) {
		int rv = 0;
		SLLNode<E> cursor = head.getNext();

		while((cursor != tail) && (!cursor.getNodeData().equals(targetData))) {
			cursor = cursor. getNext();
			++rv;
		}// Ending bracket of while loop

		if(rv == this.size()) {
			rv = -1;
		}// Ending bracket of if

		return rv;
	}// Ending bracket of method findIndex

	/**
	 * @param targetData
	 * @return SLLNode<E>
	 */
	private SLLNode<E> find(E targetData) {
		SLLNode<E> rv = new SLLNode<E>();

		SLLNode<E> cursor = head.getNext();

		while(cursor != tail) {
			if (cursor.getNodeData().equals(targetData)) {
				rv = cursor;
				break;
			} else {
				cursor = cursor.getNext();
			}// Ending bracket of if
		}// Ending bracket of while loop
		return rv;
	}// Ending bracket of method find(E)

	/**
	 * @param position
	 * @return SLLNode<E>
	 */
	private SLLNode<E> find(int position) {
		SLLNode<E> cursor = head.getNext();
		int index = 0;

		while((index != position) && (cursor != tail)) {
			++index;
			cursor = cursor.getNext();
		}// Ending bracket of while loop

		return cursor;
	}// Ending bracket of method find (int)

}// Ending bracket of class SLL