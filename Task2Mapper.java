package Assignment_3_Task2;												// Package Declared
import java.io.IOException;												// IOException class import to handle exceptions
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task2Mapper 												// Class declared
	extends Mapper<LongWritable, Text, Text, IntWritable> {				// class is extended to have the arguments keyIn as LongWritable and ValueIn as Text and KeyOut as Text and ValueOut as IntWritable.
	Text Company_Name_Key = new Text();									// The variables declared are: a Text variable Company_Name_Key
	IntWritable Company_Name_Value = new IntWritable();					// The variables declared are: a IntWritable variable Company_Name_Value which will store the value of the MapReduce deals with Key and Value pairs.
	@Override
	public void map(LongWritable key, Text value, Context context) 		// overriding the map method which will run one time for every line.
			throws IOException, InterruptedException {					// throws for exception handling
		String[] myLineArray = value.toString().split("\\|");			// storing the line in a string variable and splitting the line by using comma “|” delimiter and storing the values in a String Array so that all the columns in a row are stored in the string array.
		Company_Name_Key.set(myLineArray[0]);							// setting the array  
		Company_Name_Value.set(1);										// set to 1
		context.write(Company_Name_Key, Company_Name_Value);			// obtaining key and value context.
	}																	// map class closed
}																		// class Task2Mapper closed

