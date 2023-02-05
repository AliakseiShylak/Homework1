public class TaskFirstStarBest {
    public static void main(String[] args) {
		int[] array = {4, 3, 5, 8, 6, 2};
		//int[] array = {2, 1, 5, 6, 0, 3, 10, 20, 0, 0, 0, 0, 30};
		int sum = array[0];
		int prevSum = 0;


		for (int i = 1; i < array.length; i++) {
			int temp = sum;
			sum = Math.max(prevSum + array[i], sum);
			prevSum = temp;
            System.out.println(temp + " " + sum + " " + array[i] + " " + prevSum);
		}

		System.out.println(sum);
    }
}
