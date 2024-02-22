TARGET=program.c
OUT=$(basename $(TARGET)).o

OUT:
	gcc -Wall $(TARGET) -o $(OUT)

RUN: $(OUT)
	./$(OUT)

RUNV: $(OUT)
	valgrind --leak-check=yes ./$(OUT)

RUNT: $(OUT)
	time ./$(OUT)