from sys import argv
import string
import random

def sequence_generator(size=6, chars=string.ascii_uppercase + string.digits):
    return ''.join(random.choice(chars) for _ in range(size))

script, filename, n = argv

file = open(filename, 'w')
file.truncate()

for i in range(0,10):
    sequence1 = sequence_generator(int(n), "ACGT")
    sequence2 = sequence_generator(int(n), "ACGT")

    file.write(sequence1 + "," + sequence2)
    file.write("\n")

file.close()


