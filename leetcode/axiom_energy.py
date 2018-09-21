class Solution:

    def add_loop_1(self, nums):
        result = 0
        for item in nums:
            result += item
        return result

    def add_loop_2(self, nums):
        result, i, n = 0, 0, len(nums)
        while i < n:
            result += nums[i]
            i += 1
        return result

    def add_recursion(self, nums):
        if len(nums) == 0:
            return 0

        return nums[0] + self.add_recursion(nums[1:])

    def zip_custom(self, *iterables):
        sentinel = object()
        iterators = [iter(it) for it in iterables]
        while iterators:
            result = []
            for it in iterators:
                elem = next(it, sentinel)
                if elem is sentinel:
                    return
                result.append(elem)
            yield result

    def zip_custom_1(self, *iterables):
        sentinal = object()
        iterators = [iter(it) for it in iterables]
        result = []
        while iterators:
            for it in iterators:
                elem = next(it, sentinal)
                if elem is sentinal:
                    iterators = None
                    break
                result.append(elem)
        return result

    def fibonacci_series(self, n):

        if n <= 1:
            return (n, 0)
        else:
            (a, b) = self.fibonacci_series(n - 1)
            return (a + b, a)

    def fib(self, n):
        result = []
        if n <= 0:
            return result

        result.append(0)
        if n == 1:
            return result

        result.append(1)
        if n == 2:
            return result

        for i in range(2, n):
            result.append(result[i - 2] + result[i - 1])
        return result

if __name__ == '__main__':
    print(Solution().add_loop_1([1, 2, 3]))
    print(Solution().add_loop_2([1, 2, 3]))
    print(Solution().add_recursion([1, 2, 3]))
    print(list(Solution().zip_custom_1([1, 2, 3], ['a', 'b', 'c'])))
    print(Solution().fibonacci_series(5))
    print(Solution().fib(2))
