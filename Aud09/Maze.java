package Aud09;

import java.util.Scanner;

/*
######
# # ##
# # S#
# # ##
# E # 
######
*/


public class Maze {		
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		String parts[] = tmp.split(",");
		
		int m = Integer.parseInt(parts[0]);
		int n = Integer.parseInt(parts[1]);
		
		String lines[] = new String[m];
		
		AdjacencyListGraph<String> mazeGraph = new AdjacencyListGraph<>();
		
		String startVertex = "";
		String endVertex = "";
		
		for(int i=0;i<m;i++) {
			lines[i] = sc.nextLine();

			for(int j = 0; j < n; j++) {
				if(lines[i].charAt(j) != '#') {
					mazeGraph.addVertex(i + "," + j);
					
					if(lines[i].charAt(j) == 'S') {
						startVertex = i + "," + j;
					} else if(lines[i].charAt(j) == 'E') {
						endVertex = i + "," + j;
					}
					
					if(i>0 && lines[i-1].charAt(j) != '#') {
						mazeGraph.addEdge((i-1) + "," + j, i + "," + j);
					}
					
					if(j>0 && lines[i].charAt(j-1) != '#') {
						mazeGraph.addEdge(i + "," + (j-1), i + "," + j);
					}
				}
			}
		}
		sc.close();
		
		mazeGraph.findPath(startVertex, endVertex);
	}

}
