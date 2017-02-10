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
    oldString = pair[0]
    newString = pair[1]

    editTable = []
    for i in range(len(newString) + 1):
        tableRow = []
        for j in range(len(oldString) + 1):
            if i == 0 and j == 0:
                tableRow.append(getCost('-','-'))
            elif i == 0:
                #tableRow.append(j)
                tableRow.append(getCost('-',oldString[j-1]))
            elif j == 0:
                #tableRow.append(i)
                tableRow.append(getCost(newString[i-1], '-'))
            elif newString[i-1] != oldString[j-1]:
                #cell = 1 + min(editTable[i-1][j-1], editTable[i-1][j], tableRow[j-1])
                cell = getCost(oldString[j-1], newString[i-1]) + min(editTable[i-1][j-1], editTable[i-1][j], tableRow[j-1])
                tableRow.append(cell)
            else:
                cell = getCost(oldString[j-1], newString[i-1]) + editTable[i-1][j-1]
                tableRow.append(cell)

        editTable.append(tableRow)

    return editTable

def findPath(pair, editTable):
    oldString = pair[0]
    newString = pair[1]

    s1 = ""
    s2 = ""

    y = len(editTable) - 1
    x = len(editTable[0]) - 1

    while y > 0 or x > 0:
        #pdb.set_trace()
        if y > 0 and x > 0:
            topLeft = editTable[y-1][x-1]
            top = editTable[y-1][x]
            left = editTable[y][x-1]

            minCell = min(topLeft, top, left)

            '''
            if topLeft == minCell and editTable[y][x] > minCell: # edit (diag)
                s1 = oldString[x-1] + s1
                s2 = newString[y-1] + s2
                y -= 1
                x -= 1

            elif topLeft == minCell: # do nothing (diag)
            '''
            if topLeft == minCell: # edit or do nothing (diag)
                s1 = oldString[x-1] + s1
                s2 = newString[y-1] + s2
                y -= 1
                x -= 1

            elif top == minCell: # insert (up)
                s1 = "-" + s1
                s2 = newString[y-1] + s2
                y -= 1

            elif left == minCell: # delete (left)
                s1 = oldString[x-1] + s1
                s2 = "-" + s2
                x -= 1

        elif y > 0: # insert the rest of s2
            s1 = "-" + s1
            s2 = newString[y-1] + s2
            y -= 1

        elif x > 0: # delete the remaining s1
            s1 = oldString[x-1] + s1
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
        pair = line.replace('\n', '').split(',')
        inputPairs.append(pair)

with open(outputName, 'w') as f:
    for pair in inputPairs:
        editTable = createTable(pair)
        editted = findPath(pair, editTable)
        numOps = str(editTable[len(editTable)-1][len(editTable[0])-1])
        f.write(",".join(editted) + ":" + numOps + "\n")
