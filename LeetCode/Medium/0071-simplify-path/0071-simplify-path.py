class Solution:
    def simplifyPath(self, path: str) -> str:
        parts = path.split("/")
        stack = []
        for part in parts:
            if part == "" or part == ".":
                continue
            elif part == "..":
                if len(stack) != 0:
                    stack.pop()
            else:
                stack.append(part)
        return "/" + "/".join(stack)
        