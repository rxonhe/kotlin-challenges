package challenges

import auxClasses.ListNode
import kotlin.math.max

class AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        val list1 = l1?.toList() ?: listOf()
        val list2 = l2?.toList() ?: listOf()
        var carry = 0
        val result = mutableListOf<Int>()

        for (i in 0 until max(list1.size, list2.size)) {
            val sum = (list1.getOrNull(i) ?: 0) + (list2.getOrNull(i) ?: 0) + carry
            result.add(sum % 10)
            carry = sum / 10
        }

        if (carry > 0) {
            result.add(carry)
        }
        return listNodeFromList(result)
    }

    private fun ListNode.toList(): List<Int> {
        val tempList = mutableListOf<Int>()
        this.let {
            var current: ListNode? = it
            while (current != null) {
                tempList.add(current.`val`)
                current = current.next
            }
        }
        return tempList
    }

    private fun listNodeFromList(list: List<Int>): ListNode {
        val head = ListNode(list.first())
        var current = head
        list.drop(1).map {
            current.next = ListNode(it)
            current = current.next!!
        }
        return head
    }
}



