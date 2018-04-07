import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BinaryTreeExperiment {
	private int[] createArray;
	private int[] randomArray;
	private int[] modifyArray;
	private ArrayList<Integer> treeValues;
	private BinarySearchTree tree;

	public BinaryTreeExperiment() {
		createArray = new int[1023];//changes this you fucking idiot 
		modifyArray = new int[511];//and this
		treeValues = new ArrayList<Integer>();
		tree = new BinarySearchTree();

		for (int i = 0; i < 1023; i++) {//and this 
			createArray[i] = i;
		}
		randomArray = new int[1023];//and this
		shuffle();
		

	}

	private void shuffle() {
		ArrayList<Integer> temp = new ArrayList<Integer>();// create an ArrayList so i can use Collections
		for (int i = 0; i < createArray.length; i++) {
			temp.add(createArray[i]);// store data into arrayList
		}
		Collections.shuffle(temp);
		for (int i = 0; i < temp.size(); i++) {
			randomArray[i] = temp.get(i);// stores newly shuffled data into randomArray
		}

	}

	// tree creations
	public void balTree(int[] arr, int low, int high) {
		
		if(low > high) {
			return;
		}
		int mid = (low + high)/2;
		tree.insert(mid);
		balTree(arr,low, mid-1);
		balTree(arr,mid+1, high);
		
		
	}

	private void randTree() {
		for (int i = 0; i < randomArray.length; i++) {
			tree.insert(randomArray[i]);
		}

	}

	// tree operations:
	public void delete() {
		Random r = new Random();

		int randNode;
		for (int i = 0; i < 511; i++) {
			randNode = r.nextInt(1022);
			modifyArray[i]= randNode;// in the instructions it says to re-insert some of the deleted nodes so thats
											// why i am storing it in modify array
			tree.delete(tree.getRoot(),randNode);
		}
	}

	public void reinsert() {
		for (int i = 0; i < 255; i++) {
			tree.insert(modifyArray[i]);// this inserts the deleted nodes
		}

	}

	public int getHeight(BSTNode obj) {
		if (obj == null) {
			return 0;
		}
		int left = getHeight(obj.getLeft());
		int right = getHeight(obj.getRight());
		if (left > right) {
			return left + 1;
		}
		return right + 1;

	}

	public void storeTreeValues(BSTNode obj) {
		if (obj != null) {
			treeValues.add(obj.getValue());
			storeTreeValues(obj.getLeft());
			storeTreeValues(obj.getRight());
		}
		return;

	}

	public static void main(String[] args) {
		Sample createBalance = new Sample();
		Sample deleteBalance = new Sample();
		Sample reinsertBalance = new Sample();
		Sample createRandom = new Sample();
		Sample deleteRandom = new Sample();
		Sample reinsertRandom = new Sample();

		BinaryTreeExperiment Bal = new BinaryTreeExperiment();
		BinaryTreeExperiment Rand = new BinaryTreeExperiment();

		double start, end, total;// this is to keep track of time

		// this is the beginning of the Balance tree stuff
		start = System.nanoTime();// tracks time when creation of balance tree starts

		Bal.balTree(Bal.createArray, 0, Bal.createArray.length);
		

		end = System.nanoTime();// tracks time when balance tree is finished

		total = end - start;// this is how much time it took for the balance tree to be created
		System.out.println("Balance tree created in : " + total + " nanoseconds");

		Bal.storeTreeValues(Bal.tree.getRoot());// this stores all the values in the Balance tree

		for (int i = 0; i < Bal.treeValues.size(); i++) {
			createBalance.addData((double) Bal.treeValues.get(i));// this loads the values into Sample
		}
		createBalance.computeStats();// calculates the Values
		System.out.println("This is the average: " + createBalance.getMean() + " This is the max value: "
				+ createBalance.getMax() + "\n");

		Bal.treeValues.clear();// this resets data in treeValues

		// this is the deletion of Bal tree nodes

		start = System.nanoTime();
		Bal.delete();
		end = System.nanoTime();
		total = end - start;
		System.out.println("It took this long to delete the nodes : " + total + " nano seconds");

		Bal.storeTreeValues(Bal.tree.getRoot());
		for (int i = 0; i < Bal.treeValues.size(); i++) {
			deleteBalance.addData((double) Bal.treeValues.get(i));
		}
		deleteBalance.computeStats();
		System.out.println("This is the average: " + deleteBalance.getMean() + " This is the max value: "
				+ deleteBalance.getMax() + "\n");

		Bal.treeValues.clear();

		// this is the reInsertion of some of the deleted Nodes
		start = System.nanoTime();
		Bal.reinsert();
		end = System.nanoTime();
		total = end - start;
		System.out.println("It took this long to reinserts the nodes : " + total + " nano seconds");

		Bal.storeTreeValues(Bal.tree.getRoot());
		for (int i = 0; i < Bal.treeValues.size(); i++) {
			reinsertBalance.addData((double) Bal.treeValues.get(i));
		}
		reinsertBalance.computeStats();
		System.out.println("This is the average: " + reinsertBalance.getMean() + " This is the max value: "
				+ reinsertBalance.getMax() + "\n");
		// this is the end of Balance tree stuff

		// Random tree time

		start = System.nanoTime();// tracks time when creation of random tree starts

		Rand.randTree();

		end = System.nanoTime();// tracks time when random tree is finished

		total = end - start;// this is how much time it took for the random tree to be created

		System.out.println("Random tree created in : " + total + " nanoseconds");

		Rand.storeTreeValues(Rand.tree.getRoot());// this stores all the values in the random tree

		for (int i = 0; i < Rand.treeValues.size(); i++) {
			createRandom.addData((double) Rand.treeValues.get(i));// this loads the values into Sample
		}
		createRandom.computeStats();// calculates the Values
		System.out.println(
				"This is the average: " + createRandom.getMean() + " This is the max value: " + createRandom.getMax() + "\n");

		Rand.treeValues.clear();// this resets data in treeValues

		// this is the deletion of Rand tree nodes

		start = System.nanoTime();
		Rand.delete();
		end = System.nanoTime();
		total = end - start;
		System.out.println("It took this long to delete the nodes : " + total + " nanoseconds");

		Rand.storeTreeValues(Rand.tree.getRoot());
		for (int i = 0; i < Rand.treeValues.size(); i++) {
			deleteRandom.addData((double) Rand.treeValues.get(i));
		}
		deleteRandom.computeStats();
		System.out.println(
				"This is the average: " + deleteRandom.getMean() + " This is the max value: " + deleteRandom.getMax() + "\n");

		Rand.treeValues.clear();

		// this is the reInsertion of some of the deleted Nodes
		start = System.nanoTime();
		Rand.reinsert();
		end = System.nanoTime();
		total = end - start;
		System.out.println("It took this long to reinsert the nodes : " + total + " nanosecond");

		Rand.storeTreeValues(Rand.tree.getRoot());
		for (int i = 0; i < Rand.treeValues.size(); i++) {
			reinsertRandom.addData((double) Rand.treeValues.get(i));
		}
		reinsertRandom.computeStats();
		System.out.println("This is the average: " + reinsertRandom.getMean() + " This is the max value: "
				+ reinsertRandom.getMax() +"\n");

	}

}
