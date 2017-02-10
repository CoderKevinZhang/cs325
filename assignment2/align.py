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

def createTable(pair):
    editTable = []
    for i in range(len(pair[1]) + 1):
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

def findPath(pair, editTable):
    s1 = ""
    s2 = ""

    y = len(editTable) - 1
    x = len(editTable[0]) - 1

    while y > 0 or x > 0:
        #pdb.set_trace()
        if y > 0 and x > 0:
            minCell = min(editTable[y-1][x-1], editTable[y-1][x], editTable[y][x-1])

            if editTable[y-1][x-1] == minCell and editTable[y][x] > minCell: # edit (diag)
                s1 = pair[0][x-1] + s1
                s2 = pair[1][y-1] + s2
                y -= 1
                x -= 1

            elif editTable[y-1][x-1] == minCell: # do nothing (diag)
                s1 = pair[0][x-1] + s1
                s2 = pair[1][y-1] + s2
                y -= 1
                x -= 1

            elif editTable[y-1][x] == minCell: # insert (up)
                s1 = "-" + s1
                s2 = pair[1][y-1] + s2
                y -= 1

            elif editTable[y][x-1] == minCell: # delete (left)
                s1 = pair[0][x-1] + s1
                s2 = "-" + s2
                x -= 1

        elif y > 0: # insert the rest of s2
            s1 = "-" + s1
            s2 = pair[1][y-1] + s2
            y -= 1

        elif x > 0: # delete the remaining s1
            s1 = pair[0][x-1] + s1
            s2 = "-" + s2
            x -= 1

    return [s1, s2]

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

with open(outputName, 'w') as f:
    for pair in inputPairs:
        editTable = createTable(pair)
        editted = findPath(pair, editTable)
        numOps = str(editTable[len(editTable)-1][len(editTable[0])-1])
        f.write(",".join(editted) + ":" + numOps + "\n")
