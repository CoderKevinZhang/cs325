import pdb
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

def editDistance(pair):
    editTable = []
    for i in range(len(pair[1]) + 1):
        #pdb.set_trace()
        tableRow = []
        for j in range(len(pair[0]) + 1):
            if i == 0:
                tableRow.append(j)
            elif j == 0:
                tableRow.append(i)
            elif pair[1][i-1] != pair[0][j-1]:
                cell = 1 + min(editTable[i-1][j-1], editTable[i-1][j], tableRow[j-1])
                tableRow.append(cell)
            else:
                cell = editTable[i-1][j-1]
                tableRow.append(cell)

        editTable.append(tableRow)

    return editTable

script, costName, inputName, outputName = argv

costMatrix = []

with open(costName, 'r') as f:
    for line in f:
        costMatrix.append(line.split(','))

inputPairs = []

with open(inputName, 'r') as f:
    for line in f:
        pair = line.split(',')
        inputPairs.append(pair)

#with open(outputName, 'w') as f:
#    for pair in inputPairs:
#        f.write(",".join(editDistance(pair)))
