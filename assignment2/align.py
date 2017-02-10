from sys import argv

def getCost(old, new):

    if old not in "-ACGT" or new not in "-ACGT":
        return -1

    row = -1
    col = -1

    for i in range(6):
        if costMatrix[0][i] == old:
            row = i
        if costMatrix[i][0] == new:
            col = i

    return int(costMatrix[row][col]);


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
