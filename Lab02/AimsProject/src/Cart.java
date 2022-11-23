import java.util.Arrays;
import java.util.Objects;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private Dvd itemsOrdered[] = new Dvd[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;

	 public void addDVD(Dvd disc) {
	        if(qtyOrdered == MAX_NUMBERS_ORDERED) {
	            System.out.println("Your cart is already full!");
	            return;
	        }
	        itemsOrdered[qtyOrdered] = disc;
	        qtyOrdered ++;
	        if(qtyOrdered == MAX_NUMBERS_ORDERED) {
	            System.out.println("Your cart is full now.");
	        } else {
	            System.out.println("Disc added successfully!");
	        }
	    }

	    public void removeDVD(Dvd disc) {
	    	int index = 0;
	    	for(int i=0;i<qtyOrdered;i++) {
	    		if(itemsOrdered[i].equals(disc)) {
	    			index = i;
	    			System.out.println("Remove: " + itemsOrdered[i].getTitle());
	    			break;
	    		}else if(i == qtyOrdered -1) {
	    			System.out.print("No match found!");
	    			return;
	    		}
	    	}
	    	System.arraycopy(itemsOrdered, index + 1, itemsOrdered, index, itemsOrdered.length - index - 1);
	    	qtyOrdered --;
	    	System.out.println("Removed Successfully!");
	    }

	    public float totalCost() {
	    	float total = 0;
	    	for(int i=0; i<qtyOrdered;i++) {
	    		total += itemsOrdered[i].getCost();
	    	}
	        return total;
	    }
}
