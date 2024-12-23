#!/bin/bash

# Input and output directories
CLASS_DIR="/home/dorustree/Downloads/ZJ2009E 2/WEB-INF/classes"
OUTPUT_DIR="/home/dorustree/Downloads/ZJ2009E 2/WEB-INF/converted"

# Create output directory if not exists
mkdir -p "$OUTPUT_DIR"

# Decompile all .class files
find "$CLASS_DIR" -name "*.class" | while read class_file; do
    # Generate output path for the .java file
    relative_path=${class_file#$CLASS_DIR/}
    output_file="$OUTPUT_DIR/${relative_path%.class}.java"

    # Create directory structure for the output file
    mkdir -p "$(dirname "$output_file")"

    echo "Decompilation started for: $class_file"
    # Run CFR decompiler
    java -jar cfr.jar "$class_file" > "$output_file"
done

echo "Decompilation complete! Decompiled files are in: $OUTPUT_DIR"
