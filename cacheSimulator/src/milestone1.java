import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class milestone1 {
	public static void main(String[] args) {
		String[] trace_file = new String[3];
		int cache_size = 0;
		int block_size = 0;
		int associativity = 0;
		String replacement_policy = null;
		String memory_size = null;
		int x=0;
		for (int i=0; i<args.length; i++) {
			if ("-f".equals(args[i]) && i+1 < args.length) {
				trace_file[x] = args[i+1];
				i++;
				x++;
			}else if("-s".equals(args[i]) && i+1 < args.length) {
				cache_size = Integer.parseInt(args[i+1]);
				i++;
			}else if("-b".equals(args[i]) && i+1 < args.length) {
				block_size = Integer.parseInt(args[i+1]);
				i++;
			}else if("-a".equals(args[i]) && i+1 < args.length) {
				associativity = Integer.parseInt(args[i+1]);
				i++;
			}else if("-r".equals(args[i]) && i+1 < args.length) {
				replacement_policy = args[i+1];
				i++;
			}else if("-p".equals(args[i]) && i+1 < args.length) {
				memory_size = args[i+1];
				i++;
			}
		}
		System.out.println("Cache Simulator - CS 3853 Fall 2023 - Group#2\n");
		if(trace_file[0] != null) {
			trace1(trace_file[0],cache_size,block_size,associativity,replacement_policy,memory_size);
		}
		if(trace_file[1] != null) {
			trace2(trace_file[1],cache_size,block_size,associativity,replacement_policy,memory_size);
		}
		if(trace_file[2] != null) {
			trace2(trace_file[2],cache_size,block_size,associativity,replacement_policy,memory_size);
		}
	}
	public static void trace1(String trace_file,int cache_size,int block_size,int associativity,String replacement_policy,String memory_size) {
		int total_block = ((cache_size*1024)/block_size);
		int rows_num = total_block / associativity;
		int index_size = (int) (Math.log(rows_num) / Math.log(2));
		int offset_size = (int) (Math.log(block_size)/Math.log(2));
		int tag_size = (int) (index_size+offset_size);
		int overhead_size = rows_num*(tag_size+1);
		int implement_memSizeb = ((cache_size*1024)+overhead_size);
		double implement_memSizekb = implement_memSizeb / 1024;
		double cost_perkb = 0.09;
		double cost = Math.round((implement_memSizekb * cost_perkb)*100.0)/100.0;
		System.out.println("Trace File: "+ trace_file+"\n");
		System.out.println("***** Cache Input Parameters ******");
		System.out.println("Cache Size: \t\t"+cache_size+" KB");
		System.out.println("Block Size: \t\t"+block_size+" bytes");
		System.out.println("Associativity: \t\t"+associativity);
		System.out.println("Replacement Policy: \t"+replacement_policy+"\n\n");
		System.out.println("***** Cache Calculated Values *****");
		System.out.println("Total # Blocks: \t\t"+total_block);
		System.out.println("Tag Size: \t\t\t"+tag_size+" bits");
		System.out.println("Index Size: \t\t\t"+index_size+" bits");
		System.out.println("Total # Rows: \t\t\t"+rows_num);
		System.out.println("Overhead Size: \t\t\t"+overhead_size+" bytes");
		System.out.println("Implementation Memory Size: \t"+implement_memSizekb+" KB ("+implement_memSizeb+" bytes)");
		System.out.println("Cost: \t\t\t\t$"+cost+" @ ($"+cost_perkb+" / KB)");
		fileRead(trace_file);
		System.out.println("\n\n");
	}
	public static void trace2(String trace_file,int cache_size,int block_size,int associativity,String replacement_policy,String memory_size) {
		int total_block = ((cache_size*1024)/block_size);
		int rows_num = total_block / associativity;
		int index_size = (int) (Math.log(rows_num) / Math.log(2));
		int offset_size = (int) (Math.log(block_size)/Math.log(2));
		int tag_size = (int) (index_size+offset_size);
		int overhead_size = rows_num*(tag_size+1);
		int implement_memSizeb = ((cache_size*1024)+overhead_size);
		double implement_memSizekb = implement_memSizeb / 1024;
		double cost_perkb = 0.09;
		double cost = Math.round((implement_memSizekb * cost_perkb)*100.0)/100.0;
		System.out.println("Trace File: "+ trace_file+"\n");
		System.out.println("***** Cache Input Parameters ******");
		System.out.println("Cache Size: \t\t"+cache_size+" KB");
		System.out.println("Block Size: \t\t"+block_size+" bytes");
		System.out.println("Associativity: \t\t"+associativity);
		System.out.println("Replacement Policy: \t"+replacement_policy+"\n\n");
		System.out.println("***** Cache Calculated Values *****");
		System.out.println("Total # Blocks: \t\t"+total_block);
		System.out.println("Tag Size: \t\t\t"+tag_size+" bits");
		System.out.println("Index Size: \t\t\t"+index_size+" bits");
		System.out.println("Total # Rows: \t\t\t"+rows_num);
		System.out.println("Overhead Size: \t\t\t"+overhead_size+" bytes");
		System.out.println("Implementation Memory Size: \t"+implement_memSizekb+" KB ("+implement_memSizeb+" bytes)");
		System.out.println("Cost: \t\t\t\t$"+cost+" @ ($"+cost_perkb+" / KB)");
		fileRead(trace_file);
		System.out.println("\n\n");
	}
	public static void trace3(String trace_file,int cache_size,int block_size,int associativity,String replacement_policy,String memory_size) {
		int total_block = ((cache_size*1024)/block_size);
		int rows_num = total_block / associativity;
		int index_size = (int) (Math.log(rows_num) / Math.log(2));
		int offset_size = (int) (Math.log(block_size)/Math.log(2));
		int tag_size = (int) (index_size+offset_size);
		int overhead_size = rows_num*(tag_size+1);
		int implement_memSizeb = ((cache_size*1024)+overhead_size);
		double implement_memSizekb = implement_memSizeb / 1024;
		double cost_perkb = 0.09;
		double cost = Math.round((implement_memSizekb * cost_perkb)*100.0)/100.0;
		System.out.println("Trace File: "+ trace_file+"\n");
		System.out.println("***** Cache Input Parameters ******");
		System.out.println("Cache Size: \t\t"+cache_size+" KB");
		System.out.println("Block Size: \t\t"+block_size+" bytes");
		System.out.println("Associativity: \t\t"+associativity);
		System.out.println("Replacement Policy: \t"+replacement_policy+"\n\n");
		System.out.println("***** Cache Calculated Values *****");
		System.out.println("Total # Blocks: \t\t"+total_block);
		System.out.println("Tag Size: \t\t\t"+tag_size+" bits");
		System.out.println("Index Size: \t\t\t"+index_size+" bits");
		System.out.println("Total # Rows: \t\t\t"+rows_num);
		System.out.println("Overhead Size: \t\t\t"+overhead_size+" bytes");
		System.out.println("Implementation Memory Size: \t"+implement_memSizekb+" KB ("+implement_memSizeb+" bytes)");
		System.out.println("Cost: \t\t\t\t$"+cost+" @ ($"+cost_perkb+" / KB)");
		fileRead(trace_file);
		System.out.println("\n\n");
	}
	public static int fileRead(String fileName) {
		try {
			String fileInput = fileName;
			int i=0;
			BufferedReader br = new BufferedReader(new FileReader(fileInput));
            String line;
            Pattern pattern = Pattern.compile("EIP \\((\\d+)\\): ([0-9a-fA-F]+)");
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String length = 000+matcher.group(1);
                    String hexValue = matcher.group(2);
                    System.out.println("0x" + hexValue+":("+length+")");
                    i++;
                    if(i==20) {
                    	return 1;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return 0;
    }
}
