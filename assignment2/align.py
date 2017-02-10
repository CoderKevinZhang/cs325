from sys import argv

script, costName, inputName, outputName = argv

costMatrix = []
pairs = []

with open(costName, 'r') as f:
    for line in f:
        costMatrix.append(line.split(','))

with open(inputName, 'r') as f:
    for line in f:
        pair = line.split(',')
        pairs.append(pair)

# INSERT ALGORITHM HERE #

with open(outputName, 'w') as f:
    for pair in pairs:
        f.write(",".join(pair))
