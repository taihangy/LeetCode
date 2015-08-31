class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        queue2, queue3, queue5 = [2], [3], [5]
        num = 1
        for _ in xrange(n - 1):
            if min(queue2[0], queue3[0], queue5[0]) == queue2[0]:
                num = queue2.pop(0)
                queue2.append(num * 2)
                queue3.append(num * 3)
                queue5.append(num * 5)
            elif min(queue2[0], queue3[0], queue5[0]) == queue3[0]:
                num = queue3.pop(0)
                queue3.append(num * 3)
                queue5.append(num * 5)
            else:
                num = queue5.pop(0)
                queue5.append(num * 5)
        return num
