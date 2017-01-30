compile:
    make

run individually:
    java Bruteforce [input_file]
    java Divideandconquer [input_file]
    java Enhanceddnc [input_file]

run all:
    make test


Input files will be generated with make. The convention used it that X.input would imply n = 10^X and that outputX_Y.txt would imput that n = 10^X and the Y = algorithm.
