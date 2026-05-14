class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        n = len(graph)  # 节点总数

        target = n - 1  # 终点节点编号
        result = []  # 存所有完整路径

        def dfs(node, path):
        # path 是从起点到当前节点走过的路径（包含当前节点）

        # 第1步：如果当前节点是终点，找到一条完整路径
            if node == target:
                result.append(list(path))  # 必须用 list(path) 复制一份，原因见下方说明
                return

        # 第2步：遍历当前节点的所有邻居
            for neighbor in graph[node]:
                path.append(neighbor)  # 走向邻居：把邻居加入路径
                dfs(neighbor, path)  # 递归深入
                path.pop()  # 回溯：返回后撤销这一步，把邻居移除

    # 起点是节点 0，初始路径只包含节点 0
        dfs(0, [0])
        return result
