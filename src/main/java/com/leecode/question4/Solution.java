package com.leecode.question4;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0d;
		int pointerNumS1 = 0;
		int pointerNumS2 = 0;
		int s1Length = nums1 == null? 0: nums1.length;
		int s2Length = nums2 == null? 0: nums2.length;
		int[] sum = new int[s1Length + s2Length];
		int pointerSum = 0;
		int resultLength = s1Length + s2Length;
		while(pointerSum < resultLength) {
			int newValue = 0;
            if (nums1 == null){
                newValue = nums2[pointerNumS2];
                pointerNumS2 ++;
            }else if (nums2 == null){
                newValue = nums1[pointerNumS1];
                pointerNumS1 ++;
            }else if (pointerNumS1 >= s1Length && pointerNumS2 < s2Length) {
				newValue = nums2[pointerNumS2];
				pointerNumS2 ++;
			}else if (pointerNumS2 >= s2Length && pointerNumS1 < s1Length) {
				newValue = nums1[pointerNumS1];
				pointerNumS1 ++;
			}else  if (nums1[pointerNumS1] > nums2[pointerNumS2]) {
				newValue = nums2[pointerNumS2];
				pointerNumS2 ++;
			}else if (nums2[pointerNumS2] >= nums1[pointerNumS1]) {
				newValue = nums1[pointerNumS1];
				pointerNumS1 ++;
			}
			sum[pointerSum] = newValue;
			pointerSum ++;
		}
		if (resultLength % 2 == 0) {
			result = (sum[(resultLength / 2)] + sum[resultLength / 2 - 1]) / 2.0;
		}else {
			result = sum[resultLength / 2];
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[5];
		int[] nums2 = new int[5];
		nums1[0] = 1;
		nums1[2] = 5;
		nums1[1] = 3;
		nums1[3] = 8;
		nums1[4] = 12;
		nums2[0] = 2;
		nums2[1] = 4;
		nums2[2] = 5;
		nums2[3] = 6;
		nums2[4] = 9;
		Solution solution = new Solution();
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));
	}
}

