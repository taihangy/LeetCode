class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        if board == None or len(board) != 9 or len(board[0]) != 9:
            return False

        for row in xrange(3):
            for col in range(3):
                existed = [False] * 10
                for i in xrange(row * 3, row * 3 + 3):
                    for j in xrange(col * 3, col * 3 + 3):
                        entry = board[i][j]
                        if entry == '.':
                            continue
                        if existed[int(entry)]:
                            return False
                        else:
                            existed[int(entry)] = True

        for row in xrange(9):
            entry_list = board[row]
            existed = [False] * 10
            for entry in entry_list:
                if entry != '.':
                    if existed[int(entry)]:
                        return False
                    else:
                        existed[int(entry)] = True

        for col in xrange(9):
            existed = [False] * 10
            for row in xrange(9):
                entry = board[row][col]
                if entry != '.':
                    if existed[int(entry)]:
                        return False
                    else:
                        existed[int(entry)] = True

        return True


# xrange 与 range 的区别 range直接是list，xrange是list的前一步，循环很大时用xrange效果更好
