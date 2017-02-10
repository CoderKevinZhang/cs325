all: input test

test: test_random test_sample

test_sample:
	python alignment.py imp2input.txt imp2output_mine.txt
	diff imp2output_our.txt imp2output_mine.txt

test_random:
	python alignment.py 500.input 500.output
	python alignment.py 1000.input 1000.output
	python alignment.py 2000.input 2000.output
	python alignment.py 4000.input 4000.output
	python alignment.py 5000.input 5000.output

input:
	python inputGenerator.py 500.input 500
	python inputGenerator.py 1000.input 1000
	python inputGenerator.py 2000.input 2000
	python inputGenerator.py 4000.input 4000
	python inputGenerator.py 5000.input 5000

clean:
	rm -f  *.input *.output
