class MyStack:

    def __init__(self):
        self.queue = deque()

    def push(self, x: int) -> None:
        # 第一步：把 x 追加到队尾
        self.queue.append(x)
        # 第二步：旋转 (当前长度 - 1) 次
        # 旋转 = 把队头元素取出，重新追加到队尾
        # 执行完之后，x 从队尾转到了队头，成为新栈顶
        rotate_count = len(self.queue) - 1
        for _ in range(rotate_count):
            self.queue.append(self.queue.popleft())
        

    def pop(self) -> int:
        return self.queue.popleft()
        

    def top(self) -> int:
        return self.queue[0]
        

    def empty(self) -> bool:
        return not self.queue
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()