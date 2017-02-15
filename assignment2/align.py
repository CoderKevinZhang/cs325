import pdb
#from sys import argv
import sys

costMatrix = []

def getCost(old, new):

    if (type(old) is not str or type(new) is not str
        or len(old) != 1 or len(new) != 1
        or old not in "-ACGT" or new not in "-ACGT"):
        return -1

    col = -1
    row = -1

    for i in range(1,6):
        if costMatrix[0][i] == old:
            col = i
        if costMatrix[i][0] == new:
            row = i

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
                tableRow.append(getCost(oldString[j-1], '-'))
            elif j == 0:
                tableRow.append(getCost('-', newString[i-1]))
            elif newString[i-1] != oldString[j-1]:
                cell = getCost(oldString[j-1], newString[i-1]) + min(editTable[i-1][j-1], editTable[i-1][j], tableRow[j-1])
                tableRow.append(cell)
            elif newString[i-1] == oldString[j-1]:
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
        topLeft = editTable[y-1][x-1]
        top = editTable[y-1][x]
        left = editTable[y][x-1]

        minCell = min(topLeft, top, left)

        if topLeft == minCell: # edit or do nothing (diag)
            s1 = newString[y-1] + s1
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

    return [s1, s2]

def main(argv):
    costName, inputName, outputName = argv

    with open(costName, 'r') as f:
        for line in f:
            cost = line.replace('\n', '').split(',')
            costMatrix.append(cost)

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

if __name__ == "__main__":
    main(sys.argv[1:])
