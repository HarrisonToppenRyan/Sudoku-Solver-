import pprint

def solve(bo):
    find = find_empty(bo)
    if find:
        row, col = find 
    else:
        return True

    for i in range(1,10):
        if valid(bo, (row, col), i):
            bo[row][col] = i 

            if solve(bo):
                return True
            
            bo[row][col] = 0
    return False



     
