class Solution:
    def decodeString(self, s: str) -> str:
        stack = [""]

        for c in s:
            if c != "]":
                stack.append(c)
            else:
                cur_str = ""
                while stack[-1].isalpha():
                    cur_str = stack.pop() + cur_str
                stack.pop() # [

                time_str = ""
                while stack[-1].isdigit():
                    time_str = stack.pop() + time_str
                times = int(time_str)

                stack.append(cur_str * times)              
                
        return "".join(stack)