run:
	java -classpath out/production/Capstone-Project HTMLGenerator $(ARG)

clean:
	$(RM) AUDIO/*.html VIDEO/*.html DOCUMENT/*.html IMAGE/*.html
