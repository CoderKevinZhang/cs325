all: input Bruteforce Divideandconquer Enhanceddnc

test: test_bruteforce test_divideandconquer test_enhanceddnc

input: InputGenerator
	java InputGenerator 100 2.input
	java InputGenerator 1000 3.input
	java InputGenerator 10000 4.input
	java InputGenerator 100000 5.input

InputGenerator:
	javac InputGenerator.java

Bruteforce:
	javac -Xlint Bruteforce.java

Divideandconquer:
	javac -Xlint Divideandconquer.java

Enhanceddnc:
	javac -Xlint Enhanceddnc.java

test_bruteforce:
	time java Bruteforce 2.input > output2_bruteforce.txt
	time java Bruteforce 3.input > output3_bruteforce.txt
	time java Bruteforce 4.input > output4_bruteforce.txt
	time java Bruteforce 5.input > output5_bruteforce.txt

test_divideandconquer:
	time java Divideandconquer 2.input > output2_divideandconquer.txt
	time java Divideandconquer 3.input > output3_divideandconquer.txt
	time java Divideandconquer 4.input > output4_divideandconquer.txt
	time java Divideandconquer 5.input > output5_divideandconquer.txt

test_enhanceddnc:
	time java Enhanceddnc 2.input > output2_enhanceddnc.txt
	time java Enhanceddnc 3.input > output3_enhanceddnc.txt
	time java Enhanceddnc 4.input > output4_enhanceddnc.txt
	time java Enhanceddnc 5.input > output5_enhanceddnc.txt

clean:
	rm -f *.class *.input output*
