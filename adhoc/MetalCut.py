def maxProfit(costPerCut, salePrice, lengths):
	n = len(lengths)
	results = []
	for l in reversed(range(1, min(lengths))):
		total = 0
		full_pieces = 0
		for old_len in lengths:
			pieces = 0
			extra = 0
			regular = 0
			if old_len % l == 0:
				pieces = old_len // l

			else:
				wastage = old_len % l
				new_len = old_len - wastage
				extra += 1
				pieces = new_len // l
			regular = pieces - 1
			total += extra + regular
			full_pieces += pieces

		totalProfit = (l * salePrice * full_pieces) - (costPerCut * total)
		results.append(totalProfit)

	return max(results)

if __name__ == '__main__':
	print(maxProfit(1, 10, [30, 59, 110]))
