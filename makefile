JC = javac
FLAG = -cp
DIR = -d out/production/Capstone-Project

.SUFFIXES: .java .class

.java.class:
	$(JC) $(FLAG) src/element/*.java $(DIR)
	$(JC) $(FLAG) src/readers/*.java $(DIR)
	$(JC) $(FLAG) src/Order/*.java $(DIR)
	$(JC) $(FLAG) src/*.java $(DIR)

default: clean .java.class

run:
	java -classpath out/production/Capstone-Project HTMLGenerator $(ARG)

clean:
	$(RM) -f out/production/Capstone-Project/*.class
	$(RM) -f out/production/Capstone-Project/Order/*.class
	$(RM) -f out/production/Capstone-Project/element/*.class
	$(RM) -f out/production/Capstone-Project/readers/*.class