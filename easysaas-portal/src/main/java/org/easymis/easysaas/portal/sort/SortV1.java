package org.easymis.easysaas.portal.sort;

import java.util.Arrays;

public class SortV1 {
	public static void main(String[] args) {
		int[] arr1 = { 45, 34, 59, 55 };
		Arrays.sort(arr1);// 调用方法排序即可
		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i]+",");
	}
}
