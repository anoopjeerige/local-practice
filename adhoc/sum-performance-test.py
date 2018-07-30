from time import time

start_time = time()

print(sum([i for i in range(10000)]))

end_time = time()

print(end_time - start_time) 