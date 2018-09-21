from ListNode import ListNode


class Solution:

    def mergeTwoLists(self, l1, l2):

        # Check empty lists
        if not l1:
            return l2

        if not l2:
            return l1

        # Pick first node
        if l1.val <= l2.val:
            dummyHead = l1
            l1 = l1.next
        else:
            dummyHead = l2
            l2 = l2.next

        # Add the middle nodes
        ptr = dummyHead
        while l1 and l2:
            if l1.val <= l2.val:
                ptr.next = l1
                l1 = l1.next
            else:
                ptr.next = l2
                l2 = l2.next
            ptr = ptr.next

        # Add last node(s) if any
        if l1:
            ptr.next = l1
        else:
            ptr.next = l2

        return dummyHead

    def addTwoNumbers(self, l1, l2):

        dummy = ptr = ListNode(0)
        carry = 0
        while l1 or l2:
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0
            total = x + y + carry
            carry = total // 10
            ptr.next = ListNode(total % 10)
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            ptr = ptr.next


        if carry:
            ptr.next = ListNode(1)

        return dummy.next

    def displayList(self, temp):

        while temp:
            print("{} ".format(temp.val), end=' ')
            temp = temp.next
        print()


if __name__ == '__main__':
    l1 = ListNode(0)
    l2 = ListNode(7)
    t1 = ListNode(7)
    t2 = ListNode(3)

    l1.next = t1
    l2.next = t2

    Solution().displayList(l1)
    Solution().displayList(l2)

    # Solution().displayList(Solution().mergeTwoLists(l1, l2))

    Solution().displayList(Solution().addTwoNumbers(l1, l2))
