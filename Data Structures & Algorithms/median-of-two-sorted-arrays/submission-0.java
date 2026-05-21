class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n)
            findMedianSortedArrays(nums2, nums1);
            
        int[] a = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while(p1 < m || p2 < n) {
            if(p1 < m && p2 < n) {
                if(nums1[p1] <= nums2[p2]) {
                    a[i] = nums1[p1];
                    p1++;
                }
                else {
                    a[i] = nums2[p2];
                    p2++;
                }
                i++;
            }
            else if(p1 < m) {
                while(p1 < m) {
                    a[i] = nums1[p1];
                    i++;
                    p1++;
                }
                break;
            }
            else {
                while(p2 < n) {
                    a[i] = nums2[p2];
                    i++;
                    p2++;
                }
                break;
            }
        }

        int N = a.length;
        return N % 2 == 0 ? (a[(N-1)/2] + a[N/2]) / 2.0 : a[N/2];
    }
}
