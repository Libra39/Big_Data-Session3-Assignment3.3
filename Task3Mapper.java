/**
 * 
 */
package Assignment_3_Task3;											// Package Declared
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task3Mapper 											// Class declared
	extends Mapper<LongWritable, Text, Text, IntWritable> {			// class is extended to have the arguments keyIn as LongWritable and ValueIn as Text and KeyOut as Text and ValueOut as IntWritable.
	Text Onida_Key = new Text();									// The variables declared are: a Text variable Company_Name_Key
	IntWritable Onida_Value = new IntWritable();					// The variables declared are: a IntWritable variable Company_Name_Value which will store the value of the MapReduce deals with Key and Value pairs.
	@Override
	public void map(LongWritable key, Text value, Context context)  // overriding the map method which will run one time for every line.
			throws IOException, InterruptedException {				// throws for exception handling
		String[] lineArray = value.toString().split("\\|");			// storing the line in a string variable and splitting the line by using comma “|” delimiter and storing the values in a String Array so that all the columns in a row are stored in the string array.
		if(lineArray[0].equalsIgnoreCase("ONIDA")) {
			Onida_Key.set("ONIDA" + "\t" + lineArray[3]);			// setting the array
			Onida_Value.set(1);										// set to 1
			context.write(Onida_Key, Onida_Value);	}				// obtaining key and value context.
	}																// map class closed
}																	// class Task2Mapper closed

