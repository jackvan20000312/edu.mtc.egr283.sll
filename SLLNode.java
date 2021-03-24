package edu.mtc.egr283.sll;

/****************************************************************************
 * This is the class for a single SLL Node.
 * @author Jacob Vaught
 * @version 1.00 2021-02-25
 * Copyright (c) 2010 by William Sims. All rights reserved.
 **/
public class SLLNode<T> {

	private T nodeData;
	private SLLNode<T> next;

	/**
	 * Default constructor
	 */
	public SLLNode() {
		this(null, null);
	}// Ending bracket of default constructor
	
	/**
	 * Constructor
	 * @param newNodeData
	 * @param newNext
	 */
	public SLLNode(T newNodeData, SLLNode<T> newNext) {
		this.setNodeData( newNodeData);
		this.setNext(newNext);
	}// Ending bracket of constructor
	
	/**
	* Accessor method for nodeData
	* @return the nodeData
	*/
	public T getNodeData() {
	return this.nodeData;
	}// Ending bracket of method getNodeData
	 
	/**
	* Mutator method for nodeData
	* @param nodeData the nodeData to set
	*/
	public void setNodeData(T newNodeData) {
	this.nodeData = newNodeData;
	}// Ending bracket of method setNodeData
	
	/**
	* accessor method for next
	* @return the next
	*/
	public SLLNode<T> getNext() {
		return this.next;
	}// Ending bracket of method getNext
	
	/**
	* Mutator method for next
	* @param next the next to set
	*/
	public void setNext(SLLNode<T> newNext) {
		this.next = newNext;
	}// Ending bracket of method setNext
	
}// Ending bracket of class SLLNode

