/**
 * 
 */
package Assignment_3_Task2;															// Package declared
import org.apache.hadoop.conf.Configuration;										// Import the Configuration of system parameters.
import org.apache.hadoop.fs.Path;													// used to Names a file or directory in a AbstractFileSystem for hdfs.
import org.apache.hadoop.io.Text;													// This class stores text using standard UTF8 encoding.
import org.apache.hadoop.mapreduce.Job;												// The job submitter's view of the Job.
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;						// FilterInputFormat is a convenience class that wraps InputFormat.
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;						// FilterOutputFormat is a convenience class that wraps OutputFormat.
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat; 						// TextInputFormat is a convenience class that wraps InputFormat.
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;						// TextOutputFormat is a convenience class that wraps OutputFormat.
import org.apache.hadoop.io.IntWritable;
/**
 * 2. Write a Map Reduce program to calculate the total units sold for each Company.
 * 
 * All the comments in the program will be placed on the Right-Hand-Side.
 * @author Sahil Khurana <sahilkhurana369@gmail.com
 */
public class Task2 {																// class declared
	@SuppressWarnings("deprecation")												// The @SuppressWarnings annotation disables certain compiler warnings. In this case, the warning about deprecated code ("deprecation")
	public static void main(String[] args) throws Exception {						// main class started
		Configuration conf = new Configuration();									// Create a configuration object for the job
		Job job = new Job(conf, "Assignment_3.3_Task2");							// created the new object name Job
		job.setJarByClass(Task2.class);												// Set a name of the Jar
		job.setMapOutputKeyClass(Text.class);										// Set the output Key type for the Mapper
		job.setMapOutputValueClass(IntWritable.class);								// Set the output Value type for the Mapper
		job.setOutputKeyClass(Text.class);											// Set the output Key type for the Reducer
		job.setOutputValueClass(IntWritable.class);									// Set the output Value type for the Reducer
		job.setMapperClass(Task2Mapper.class);										// Set the Mapper Class
		job.setReducerClass(Task2Reducer.class);									// Set the Reducer Class
		job.setInputFormatClass(TextInputFormat.class);								// Set the format of the input that will be provided to the program
		job.setOutputFormatClass(TextOutputFormat.class);							// Set the format of the output for the program
		FileInputFormat.addInputPath(job, new Path(args[0])); 						// Set input directories using command line arguments,arg[0] = name of input directory on HDFS 
        FileOutputFormat.setOutputPath(job, new Path(args[1]));						// Set output directories using command line arguments,arg[0] = name of output directory on HDFS
		job.waitForCompletion(true);												// Submit the job, then poll for progress until the job is complete
    }																				// main method closed
}																					// class Task1 closed
