package org.easymis.easysaas.open.sort;
/**
法三：选择排序
先找到最小元素所在位置的索引，然后将该元素与第一位上的元素进行交换。
 */
public class SortV3 {

	public static void main(String[] args) {
		int arr3[] = { 99,23, 12, 48, 56, 45 };
		for (int i = 0; i < arr3.length; i++) {
			int tem = i;
			// 将数组中从i开始的最小的元素所在位置的索引赋值给tem
			for (int j = i; j < arr3.length; j++) {
				if (arr3[j] < arr3[tem]) {
					tem = j;
				}
			}

			// 上面获取了数组中从i开始的最小值的位置索引为tem，利用该索引将第i位上的元素与其进行交换
			int temp1 = arr3[i];
			arr3[i] = arr3[tem];
			arr3[tem] = temp1;
			for (int k = 0; k < arr3.length; k++)
				System.out.print(arr3[k] + ",");
			System.out.println("!");
		}
		for (int i = 0; i < arr3.length; i++)
			System.out.print(arr3[i] + ",");
	}

}
