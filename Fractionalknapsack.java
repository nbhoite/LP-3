package DAA;


	import java.util.*;

	class Item {
	    double value, weight;

	    Item(double value, double weight) {
	        this.value = value;
	        this.weight = weight;
	    }
	}

	public class Fractionalknapsack {

	    // Comparator function to sort by value/weight ratio (descending)
	    static Comparator<Item> cmp = (a, b) -> {
	        double r1 = a.value / a.weight;
	        double r2 = b.value / b.weight;
	        if (r1 < r2) return 1;
	        else if (r1 > r2) return -1;
	        else return 0;
	    };

	    // Function to solve fractional knapsack
	    static double fractionalKnapsack(int n, double W, List<Item> items) {
	        // Sort items by value/weight ratio
	        Collections.sort(items, cmp);

	        double totalValue = 0.0;

	        for (int i = 0; i < n; i++) {
	            Item curr = items.get(i);
	            if (curr.weight <= W) {
	                // Take whole item
	                W -= curr.weight;
	                totalValue += curr.value;
	            } else {
	                // Take fractional part
	                totalValue += curr.value * (W / curr.weight);
	                break; // Knapsack is full
	            }
	        }
	        return totalValue;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of items: ");
	        int n = sc.nextInt();

	        List<Item> items = new ArrayList<>();

	        System.out.println("Enter value and weight of each item:");
	        for (int i = 0; i < n; i++) {
	            double value = sc.nextDouble();
	            double weight = sc.nextDouble();
	            items.add(new Item(value, weight));
	        }

	        System.out.print("Enter capacity of knapsack: ");
	        double W = sc.nextDouble();

	        double maxValue = fractionalKnapsack(n, W, items);
	        System.out.println("Maximum value in the knapsack = " + maxValue);

	        sc.close();
	    }
	}
