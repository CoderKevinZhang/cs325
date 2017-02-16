# compile
    make

# run individually
    java Bruteforce [input_file] > output_bruteforce.txt
    java Divideandconquer [input_file] > output_divideandconquer.txt
    java Enhanceddnc [input_file] > output_enhanceddnc.txt

# run all
    make test


Input files will be generated with make. Output files will be generated with make test. The convention used is that X.input would imply n = 10^X and that outputX_Y.txt would imply that n = 10^X and the Y = algorithm.
