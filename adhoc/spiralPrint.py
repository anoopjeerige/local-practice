def spiral_print(num):

    # Total elements range
    n = (2 * num) - 1

    # Initialize boundry limits for rows and columns
    mU, nU, mL, nL = n, n, 0, 0

    # Initialize row index, column index, and traversal directions, horizontal and vertical taking values (-1, 0, 1)
    row, col, hD, vD = 0, 0, 1, 0

    # Result to store sprial order
    result = [[0 for x in range(n)] for y in range(n)]

    # Loop through all elements
    for z in range(n ** 2):
        # Traverse and append spiral order
        result[row][col] = num
        row += vD
        col += hD

        # Right border check
        if col >= nU:
            vD = 1
            hD = 0
            col = nU - 1
            row += 1

        # Bottom border check
        if row >= mU:
            vD = 0
            hD = -1
            col -= 1
            row = mU - 1

        # Left border check
        if col < nL:
            vD = -1
            hD = 0
            col = nL
            row -= 1

        # Top border check
        if row == mL and col == nL:
            hD = 1
            vD = 0
            row += 1
            col += 1
            nL += 1
            mL += 1
            nU -= 1
            mU -= 1

        if num != 1:
            if (z + 1) % (8 * (num - 1)) == 0:
                num -= 1


    return result


def print_array(nums):
    for x in range(len(nums)):
        for y in range(len(nums[x])):
            print(nums[x][y], end=" ")
        print()


if __name__ == "__main__":

    print_array(spiral_print(5))
