package edu.mtc.egr283.sll;

public class SLLNodeDriver {
	public static void main(String[] args) {
		SLLNode<String> tailNode = new SLLNode<String>();
		tailNode.setNodeData("Tail");
		
		System.out.println(tailNode.getNodeData());
		System.out.println();
		
		SLLNode<String> middleNode = new SLLNode<String>("Middle", tailNode);
		System.out.println(middleNode.getNodeData());
		System.out.println(middleNode.getNext().getNodeData());
		System.out.println();
		
		SLLNode<String> headNode = new SLLNode<String>("Head", middleNode);
		System.out.println(headNode.getNodeData());
		System.out.println(headNode.getNext().getNodeData());
		System.out.println(headNode.getNext().getNext().getNodeData());
		System.out.println();
		
		SLLNode<String> tempNode = new SLLNode<String>(null, headNode);
		
		while(tempNode.getNext() != null) {
			tempNode = tempNode.getNext();
			System.out.println(tempNode.getNodeData());
		}// Ending bracket of while loop
		
		System.out.println("Done with list");
	}// Ending bracket of method main

}
