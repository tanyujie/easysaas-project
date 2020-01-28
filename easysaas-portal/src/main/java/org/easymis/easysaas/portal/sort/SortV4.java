package org.easymis.easysaas.portal.sort;

/**
 * 法四：反转排序 将原数组按逆序排列
 */
public class SortV4 {

	public static void main(String[] args) {
		// 将数组第i位上的元素与第arr.length-i-1位上的元素进行交换
		int[] arr4 = { 23, 12, 48, 56, 45 };
		for (int i = 0; i < arr4.length / 2; i++) {
			int tp = arr4[i];
			arr4[i] = arr4[arr4.length - i - 1];
			arr4[arr4.length - i - 1] = tp;
		}

		for (int i = 0; i < arr4.length; i++)
			System.out.print(arr4[i] + ",");
	}

}
