from sys import argv

script, inputName, outputName = argv

with open(inputName, 'r') as f:
    for line in f:
        pair = line.split(',')
        # align(pair)
        print pair
