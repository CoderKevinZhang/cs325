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
	time java Bruteforce 2.input
	time java Bruteforce 3.input
	time java Bruteforce 4.input
	time java Bruteforce 5.input

test_divideandconquer:
	time java Divideandconquer 2.input
	time java Divideandconquer 3.input
	time java Divideandconquer 4.input
	time java Divideandconquer 5.input

test_enhanceddnc:
	time java Enhanceddnc 2.input
	time java Enhanceddnc 3.input
	time java Enhanceddnc 4.input
	time java Enhanceddnc 5.input

clean:
	rm -f *.class *.input
