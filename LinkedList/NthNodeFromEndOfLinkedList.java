import java.util.*;

class Node{
    int data;
    Node next;
    Node(int d) 
    {
        data = d; 
        next = null;
    }
}
		
public class LinkedList_Element_From_Last{
	
	Node head;  
	Node tail;
	
    	void printList(Node head){
        	Node temp = head;
        	while (temp != null){
           		System.out.print(temp.data+" ");
           		temp = temp.next;
        	}  
        	System.out.println();
    	}
	
    	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
		    	tail = node;
		}
    	}
	  
    	public static void main(String args[]){
	    
        	Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		 
		while(t>0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			LinkedList_Element_From_Last llist = new LinkedList_Element_From_Last();
			int a1=sc.nextInt();
			Node head= new Node(a1);
            		llist.addToTheLast(head);
            		for (int i = 1; i < n; i++) {
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
        		GfG g = new GfG(); 
			System.out.println(g.getNthFromLast(llist.head,k));
	    		t--;
		}    
   	}
	
}

class GfG{
    
    int getNthFromLast(Node head, int n){
        
        int length = 0;
        Node iterator = head;
        while(iterator != null){
            iterator = iterator.next;
            length++;
        }
        
        iterator = head;
        int currentPosition = length;
        while(iterator != null){
            if(currentPosition == n){
                return iterator.data;
            }
            currentPosition--;
            iterator = iterator.next;
        }
    	return -1;
    	
    }
    
}

// Implemented using Stack
class GfG1{
    
    int getNthFromLast(Node head, int n){
        
        if(head == null){
            return -1;
        }
        
        int length = 0;
        Node iterator = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(iterator != null){
            stack.push(iterator.data);
            iterator = iterator.next;
            length++;
        }
        
        int value = -1;
        while(n > 0 && n <= length){
            value = stack.peek();
            stack.pop();
            n--;
        }
        return value;
    	
    }
    
}
