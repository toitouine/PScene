JC = javac
OUTPUT = out
MAIN = Main
PROCESSING = ../processing/core.jar

CP_SEP = :
# CP_SEP = ;

PSCENE = ../pscene/*.java ../pscene/controllers/*.java

CLASSES = *.java

all:
	make build
	make run

build:
	$(JC) -d $(OUTPUT) -cp .$(CP_SEP)$(PROCESSING) $(PSCENE) $(CLASSES)

run:
	java -cp $(OUTPUT)$(CP_SEP)$(PROCESSING) $(MAIN)

clean:
	rm -rf $(OUTPUT)/*
