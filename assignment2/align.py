from sys import argv

script, costMatrix, inputName, outputName = argv

pairs = []

with open(inputName, 'r') as f:
    for line in f:
        pair = line.split(',')
        pairs.append(pair)

with open(outputName, 'w') as f:
    for pair in pairs:
        f.write(",".join(pair))
