all: bruteforce divideandconquer enhanceddnc

test: test_bruteforce test_divideandconquer test_enhanceddnc

bruteforce:
	javac -Xlint Bruteforce.java

divideandconquer:
	javac -Xlint Divideandconquer.java

enhanceddnc:
	javac -Xlint Enhanceddnc.java

test_bruteforce:
	time java Bruteforce example.input

test_divideandconquer:
	time java Divideandconquer example.input

test_enhanceddnc:
	time java Enhanceddnc example.input

clean:
	rm -f *.class
