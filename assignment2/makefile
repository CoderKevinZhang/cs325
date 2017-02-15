all: input test

test: test_random test_sample

test_sample:
	python align.py imp2cost.txt imp2input.txt imp2output.txt
	python checker.py
	#diff imp2output_our.txt imp2output.txt

test_random:
	time python align.py imp2cost.txt 500.input 500.output
	time python align.py imp2cost.txt 1000.input 1000.output
	time python align.py imp2cost.txt 2000.input 2000.output
	time python align.py imp2cost.txt 4000.input 4000.output
	time python align.py imp2cost.txt 5000.input 5000.output

input:
	python inputGenerator.py 500.input 500
	python inputGenerator.py 1000.input 1000
	python inputGenerator.py 2000.input 2000
	python inputGenerator.py 4000.input 4000
	python inputGenerator.py 5000.input 5000

clean:
	rm -f  imp2output_mine.txt *.input *.output *.pyc
