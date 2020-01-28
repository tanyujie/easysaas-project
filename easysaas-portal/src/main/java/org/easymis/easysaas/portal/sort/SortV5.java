package org.easymis.easysaas.portal.sort;
/**
法五：插入排序
 */
public class SortV5 {

	public static void main(String[] args) {
		int[] arr5 = { 99,23, 120, 48, 56, 45 };
		for (int i = 1; i < arr5.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr5[j - 1] > arr5[j]) {// 大的放后面
					int tmp = arr5[j - 1];
					arr5[j - 1] = arr5[j];
					arr5[j] = tmp;
				}
			}
			for (int k = 0; k < arr5.length; k++)
				System.out.print(arr5[k] + ",");
			System.out.println("!");
		}

		for (int i = 0; i < arr5.length; i++)
			System.out.print(arr5[i] + ",");
	}

}
