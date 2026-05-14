class Node:
    def __init__(self,val):
        self.val = val
        self.next = None #不是参数，只是说"这个节点刚创建时没有下一个节点"



class MyLinkedList:

    def __init__(self):
        self.dummy = Node(0) # dummy 节点的 val 确实是 0, 但是 dummy 节点的 val 永远不会被使用
        self.size = 0

        

    def get(self, index: int) -> int:
        if index < 0 or index >= self.size:
            return -1
        p1 = self.dummy.next
        for i in range(index):
            p1= p1.next
        return p1.val
        

    def addAtHead(self, val: int) -> None:
        new_node = Node(val)
        new_node.next = self.dummy.next
        self.dummy.next = new_node

        self.size += 1
        
        

    def addAtTail(self, val: int) -> None:
        new_node = Node(val)
        p1 = self.dummy
        for i in range(self.size):
        # 靠条件来判断要不要继续走
        # for range 在开始之前就已经知道走几步，不需要条件，走完就停
                p1 = p1.next
        p1.next = new_node
        self.size +=1

        

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self.size:
            return
        if index == self.size:
            self.addAtTail(val)
            return #这里要用return, 下面还有插入逻辑， 不然会插入两次
        new_node = Node(val)
        p1 = self.dummy
        for i in range(index):
            p1 = p1.next
        new_node.next = p1.next # 循环的作用只是插入指针, 插入的操作在之后
        p1.next = new_node
        self.size += 1
        

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.size:
            return
        p1 = self.dummy
        for i in range(index):
            p1 = p1.next
        p1.next = p1.next.next
        self.size -= 1


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)