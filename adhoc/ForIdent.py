def highest_product_of_three(arr):
    """
    **********************************************************************************************************************
    Given an array_of_ints, find the highest_product you can get from three of the integers.
    """
    ## Highest product of three will be either the highest three ##
    ## numbers or the highest and the two largest negative numbers ##
    highest = 1 #max(arr[0], arr[1])
    lowest = 1 #min(arr[0], arr[1])
    highest_of_two = highest * lowest
    lowest_of_two = highest * lowest
    max_product = 1 #highest_of_two * arr[2]

    for elem in arr:
        max_product = max(max_product, elem * highest_of_two, elem * lowest_of_two)
        highest_of_two = max(highest_of_two, elem * highest, elem * lowest)
        lowest_of_two = min(lowest_of_two, elem * lowest, elem * highest)
        highest = max(highest, elem)
        lowest = min(lowest, elem)


    return max_product

highest_product_of_three([-5, -1, -3, -2])