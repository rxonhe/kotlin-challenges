package challenges

class MedianSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergedArray = merge(nums1, nums2)
        val medianIndex = mergedArray.size / 2
        return if (mergedArray.size % 2 == 0) {
            (mergedArray[medianIndex] + mergedArray[medianIndex - 1]) / 2.0
        } else {
            mergedArray[medianIndex].toDouble()
        }
    }
    private fun merge(nums1: IntArray, nums2: IntArray): IntArray {
        val mergedArray = IntArray(nums1.size + nums2.size)
        var i = 0
        var j = 0
        var k = 0
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k] = nums1[i]
                i++
            } else {
                mergedArray[k] = nums2[j]
                j++
            }
            k++
        }
        while (i < nums1.size) {
            mergedArray[k] = nums1[i]
            i++
            k++
        }
        while (j < nums2.size) {
            mergedArray[k] = nums2[j]
            j++
            k++
        }
        return mergedArray
    }
}