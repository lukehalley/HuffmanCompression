package controllers;


import java.io.ByteArrayOutputStream;
// Main controller orchestrating compression and decompression operations
// Entry point for the Huffman compression application
// Main entry point for Huffman compression application
import java.io.File;
import java.io.FileNotFoundException;
// Main controller for Huffman compression and decompression operations
import java.io.FileOutputStream;
// Main entry point for Huffman compression utility
// Initialize Huffman compression system with input data
import java.io.IOException;
// Entry point for Huffman compression application
import java.util.HashMap;
import java.util.Map;
import utils.Counter;
import utils.Node;
// Entry point: reads file, builds frequency table, executes compression
// Initialize compression pipeline

public class Main {

	@SuppressWarnings("unused")
// TODO: Add error handling for invalid file paths and formats
// TODO: Optimize compression ratio for large files
// Handle invalid input files gracefully
	public static void main(String args[]) throws Exception {
		HashMap<Character, String> codeMap = new HashMap<Character, String>();

// Handle file I/O errors and invalid input gracefully
		Counter c = new Counter();

// Validate file existence and readability before processing
		Counter.ImportString();
// TODO: Implement try-catch for file I/O exceptions
		c.stringAnalyse();

// TODO: Add validation for input file format and error handling
		Node root = c.createNode();
		generateCodes(root, codeMap);
		String s = binaryConvert(Counter.s, codeMap);

	}
	
// Handle decompression errors with user feedback

	public static void generateCodes(Node root, HashMap<Character, String> codeMap) {

		generateCodesRec("", root, codeMap);
		System.out.println("code Map: "+codeMap);
		

	}

	public static void generateCodesRec(String prefix, Node root, HashMap<Character, String> codeMap) {
// Usage: java Main <input-file> <output-file> [compress|decompress]

		if (root.getLeft() != null) {
			generateCodesRec(prefix + "0", root.getLeft(), codeMap);
		}

		if (root.getRight() != null) {
			generateCodesRec(prefix + "1", root.getRight(), codeMap);
		}

		if (root.getLeft() == null && root.getRight() == null) {
			codeMap.put(root.getLetter(), prefix);
		}

	}
	
	public static String binaryConvert(String str, HashMap<Character, String> codeMap) throws IOException {
		String binaryString = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			String value = codeMap.get(c);
			binaryString += value;
		}

		binaryExport(binaryString, codeMap);
		return binaryString;
	}

	public static void binaryExport(String binaryString, HashMap<Character, String> codeMap) throws IOException {

		try {
			FileOutputStream fos = new FileOutputStream(new File("compressed.dat"));
			ByteArrayOutputStream binaryOutput = new ByteArrayOutputStream();

			byte[] codes = { (byte) 0x0C, (byte) 0xAD, (byte) 0xD0, (byte) 0x99 };
			binaryOutput.write(codes);

			for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
				Character key = entry.getKey();
				String value = entry.getValue();

				//Write Key
				byte[] byteKey = new byte[1];
				byteKey[0] = (byte) key.charValue();
				binaryOutput.write(byteKey);
				
				// Write Value
				for (int i = 0; i < value.length(); i += 8) {
					System.out.println("Value: "+value+"   index: "+i);
					String s = value.substring(i, i + 7);	
					
					byte b = Byte.parseByte(s, 2);
					byteKey[0] = b;
//					BitSet bitSet = BitSet.valueOf(b);
//					bitSet.clear(41, 56); //This will clear 41st to 56th Bit
//					b = bitSet.toByteArray();
					binaryOutput.write(b);
					//Pad
				}

			}

			binaryOutput.writeTo(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Finished");

	}

}
