package org.stackroute;

import java.util.Scanner;

public class QueryProg {
	public static void getFileName(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		
        String[] a = (query.split(" "));
        int from=0;
        int where=a.length;
        for(int i=0;i<a.length;i++){
        	if(a[i].equals("from")){
        		from = i;
        	}
        	if(a[i].equals("where")){
        		where = i;
        	}
        		
        }
        for(int j=from+1;j<where;j++){
        	System.out.println(a[j]+" ");
        }
	}
	
	public static void getAggregate(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		query = query.replaceAll("[(]", " ");
		query = query.replaceAll("[)]", " ");
		
        String[] a = (query.split(" "));
        
        int k=1;
        for(int i=0;i<a.length;i++){
        	
        	if(a[i].equals("count") || a[i].equals("avg") || a[i].equals("min") || a[i].equals("max") || a[i].equals("sum")){
        		System.out.println("Aggregate " + k);
        		System.out.println("    Aggregate Name  : " + a[i]);
        		System.out.println("    Aggregate Field : " + a[i+1]);
        		System.out.println();
        		i=i+1;
        		k++;
        	}
        		
        }
        
	}
	
	public static void getFields(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		
        String[] a = (query.split(" "));
        
        int from=0;
        for(int i=0;i<a.length;i++){
        	if(a[i].equals("from")){
        		from = i;
        	}
        }
        
        for(int j=1;j<from;j++){
        	System.out.println(a[j]);
        }
	}
	
	public static void getOrderBy(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		
        String[] a = (query.split(" "));
        
        int orderby=0;
        for(int i=0;i<a.length;i++){
        	if(a[i].equals("order")){
        		orderby = i;
        	}
        }
        
        if(orderby != 0){
	        for(int j=orderby+2;j<a.length;j++){
	        	System.out.println(a[j]);
	        }
        }
	}
	
	public static void getGroupBy(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		
        String[] a = (query.split(" "));
        
        int groupby=0;
        int orderby=a.length;
        for(int i=0;i<a.length;i++){
        	if(a[i].equals("group")){
        		groupby = i;
        	}
        	if(a[i].equals("order")){
        		orderby = i;
        	}
        }
        
        if(groupby != 0){
	        for(int j=groupby+2;j<orderby;j++){
	        	System.out.println(a[j]);
	        }
        }
	}
	
	public static void getBasePart(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		
        String[] a = (query.split(" "));
        int where=a.length;
        for(int i=0;i<a.length;i++){
        	
        	if(a[i].equals("where")){
        		where = i;
        	}
        		
        }
        for(int j=0;j<where;j++){
        	System.out.print(a[j]+" ");
        }
        System.out.println();
	}
	
	public static void getFilterPart(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		
        String[] a = (query.split(" "));
        int where=0;
        int groupby=a.length;
        for(int i=0;i<a.length;i++){
        	
        	if(a[i].equals("where")){
        		where = i;
        	}
        	if(a[i].equals("group")){
        		groupby = i;
        	}
        		
        }
        
        if(where!=0){
	        for(int j=where+1;j<groupby;j++){
	        	System.out.print(a[j]+" ");
	        }
        }
        System.out.println();
        
        
	}
	
	public static void getFilterPartConds1(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		
        String[] a = (query.split(" "));
        int where=0;
        int groupby=a.length;
        for(int i=0;i<a.length;i++){
        	
        	if(a[i].equals("where")){
        		where = i;
        	}
        	
        	if(a[i].equals("group")){
        		groupby = i;
        	}
        		
        }
        int k = 1;
        System.out.print("Condition " + k +" : ");
        
        if(where!=0){
	        for(int j=where+1;j<groupby;j++){
	        	if(!a[j].equals("and") && !a[j].equals("or")){
	        		System.out.print(a[j]+" ");
	        	}
	        	else{
	        		k++;
	        		System.out.println();
	        		System.out.print("Condition " + k + " : ");
	        		continue;
	        	}
	        	
	        }
        }
        System.out.println();
        
        
	}
	
	
	
	public static void getFilterPartConds2(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		
        String[] a = (query.split(" "));
        int where=0;
        int groupby = a.length;
        
        for(int i=0;i<a.length;i++){
        	
        	if(a[i].equals("where")){
        		where = i;
        	}
        	
        	if(a[i].equals("group")){
        		groupby = i;
        	}
        		
        }
        int k = 1;
        System.out.println("Condition " + k +" : ");
        
        if(where!=0){
	        for(int j=where+1;j<groupby;j++){
	        	if(!a[j].equals("and") && !a[j].equals("or") && !a[j].equals("=") && !a[j].equals(">") && !a[j].equals("<") && !a[j].equals(">=") && !a[j].equals("<=") && !a[j].equals("<>")){
	        		System.out.println("    variable : " + a[j]);
	        	}else if(!a[j].equals("and") && !a[j].equals("or")){
	        		System.out.println("    operator : " + a[j]);
	        		System.out.println("    value : " + a[j+1]);
	        		j++;
	        		
	        	}else{
	        		k++;
	        		System.out.println();
	        		System.out.println("Condition " + k + " : ");
	        		continue;
	        	}
	        	
	        }
        }
        System.out.println();
        
	}
	
	public static void extractLogOps(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
		query = query.replaceAll("[(]", " ");
		query = query.replaceAll("[)]", " ");
        String[] a = (query.split(" "));
        int k =1;
        for(int i=0;i<a.length;i++){
        	
        	if(a[i].equals("and") || a[i].equals("or")){
        		System.out.println("operator "+ k + ": " + a[i] + " ");
        		k++;
        	}
        		
        }
        
	}
	
	public static void splitWords(String query){
		query = query.replaceAll(";", "");
		query = query.replaceAll(",", " ");
		query = query.replaceAll("=", " = ");
		query = query.replaceAll("\\s+", " ");
        String[] a = (query.split(" "));
               
        for(String i : a){
        	if(!i.equals(";")){
        		System.out.println(i);
        	}
        }
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        
        System.out.println("Press 1 to Split Words");
        System.out.println("Press 2 to get the file names");
        System.out.println("Press 3 to get base part of the query");
        System.out.println("Press 4 to get filter part of the query");
        System.out.println("Press 5 to seperate each condition and display in different line");
        System.out.println("Press 6 to split the condition part into variable, value and operator");
        System.out.println("Press 7 to extract the logical operators");
        System.out.println("Press 8 to extract the selected fields/information");
        System.out.println("Press 9 to extract the order by field");
        System.out.println("Press 10 to extract the group by field");
        System.out.println("Press 11 to print aggregate functions");
        System.out.println("Press 12 to exit");
        int i = 1;
        while(i == 1)
        	
        switch(scan.nextInt()){
        	case 1: splitWords(str);
        	        break;
        	case 2: getFileName(str);
	                break;
        	case 3: getBasePart(str);
	                break;
        	case 4: getFilterPart(str);
	        		break;
        	case 5: getFilterPartConds1(str);
	        		break;
        	case 6: getFilterPartConds2(str);
	        		break;
        	case 7: extractLogOps(str);
	        		break;
        	case 8: getFields(str);
	        		break;
        	case 9: getOrderBy(str);
	        		break;
        	case 10:getGroupBy(str);
	        		break;
        	case 11: getAggregate(str);
	        		break;
        	case 12: i=0;
    				break;
            default: System.out.println("invalid number ");
                    
                     
        }
        
        
        scan.close();

	}

}
