/**
 * 
 */
package Assignment_3_Task3;														// Package declared
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Task3Reducer 														// class declared
	extends Reducer<Text, IntWritable, Text, IntWritable> {						// class is extended to have the arguments keyIn as LongWritable and ValueIn as Text and KeyOut as Text and ValueOut as IntWritable.
	IntWritable Onida_Value = new IntWritable();								// The variables declared are: a IntWritable variable Company_Name_Value which will store the value of the MapReduce deals with Key and Value pairs.
	public void reduce(Text key, Iterable<IntWritable> values,Context context) 	// extends the default Reducer class with arguments KeyIn as Text and ValueIn as IntWritable which are same as the outputs of the mapper class and KeyOut as Text and ValueOut as IntWritbale which will be final outputs of our MapReduce program.
		throws IOException, InterruptedException{
	int sum = 0;																// declaring an integer sum which will store the sum of all the Company_Name_Value
	for (IntWritable value : values) {											// for each loop is taken which will run each time for the values inside the “Iterable values” which are coming from the shuffle and sort phase after the mapper phase.
		sum += value.get();}													// storing and calculating the sum of the values.
	Onida_Value.set(sum);														// setting the sum
	context.write(key, Onida_Value);											// obtaining key and value context.
	}																			// map class closed
}																				// class Task2Reducer closed
