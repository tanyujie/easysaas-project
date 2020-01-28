package org.easymis.easysaas.portal.sort;
/**
法二：冒泡排序
简单来说，冒泡排序就是重复地走访过要排序的数列，
一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
*
 */
public class SortV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 将第i位上的元素与其后的每一个元素分别比较，每次遇见更小的，就将两个元素交换位置
		// 第i位上的元素确定之后再继续确定第i+1位上的元素
		int arr2[] = { 23, 48, 12, 56, 45 };
		int temp;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = i + 1; j < arr2.length; j++) {
				if (arr2[i] > arr2[j]) {
					temp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i] + ",");
	}

}
