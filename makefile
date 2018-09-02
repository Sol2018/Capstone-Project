JC = javac
FLAG = -g
DIR = -d out/production/Capstone-Project

.SUFFIXES: .java .class

.java.class:
	$(JC) $(FLAG) src/*.java $(DIR)
	$(JC) $(FLAG) src/element/*.java $(DIR)
	$(JC) $(FLAG) src/page/*.java $(DIR)

default: clean .java.class

run:
	java -classpath out/production/Capstone-Project HTMLGenerator $(ARG)

clean:
	$(RM) -f out/production/Capstone-Project/*.class
	$(RM) -f out/production/Capstone-Project/page/*.class
	$(RM) -f out/production/Capstone-Project/element/*.class
