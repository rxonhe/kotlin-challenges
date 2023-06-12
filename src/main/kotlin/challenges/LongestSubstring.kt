package challenges

class LongestSubstring {
    fun lengthOfLongestSubstring(s: String, currentBestAnswer: Int = 0): Int {
        if (s.length <= currentBestAnswer) return currentBestAnswer

        var currentAnswer = ""
        val usingLetters = mutableSetOf<Char>()

        for (c in s) {
            if (usingLetters.contains(c)) break
            usingLetters.add(c)
            currentAnswer += c
        }

        val currentSize = currentAnswer.length
        return lengthOfLongestSubstring(s.drop(1), maxOf(currentSize, currentBestAnswer))
    }
}