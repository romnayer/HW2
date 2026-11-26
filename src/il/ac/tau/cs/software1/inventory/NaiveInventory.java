package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible[] collArr;
	private int count;

	public NaiveInventory() {
		collArr = new Collectible[INITIAL_CAPACITY];
	}

	@Override
	public void collect(Collectible collectible) {
		if (count < collArr.length) {
			collArr[count] = collectible;
			count++;
		}
		else {
			Collectible[] arr = new Collectible[2* collArr.length];
			for (int i = 0; i < collArr.length; i++) {
				arr[i] = collArr[i];
			}
			arr[count] = collectible;
			count++;
			collArr = arr;
		}
	}

	@Override
	public float getTotalWeight() {
		float total = 0;
		for (int j =0; j < count; j++){
			total += collArr[j].getWeight();
		}
		return total;
	}

	@Override
	public int getCurrentCount() {
		return count;
	}

	
	public Collectible[] getCollArr() {
		
		return collArr;
	}
}
