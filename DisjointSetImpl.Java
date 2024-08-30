import java.io.*;
import java.util.*;

class DisjointSet {
	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	List<Integer> sizeArray = new ArrayList<>();

	public DisjointSet(int n){
		for(int i=0;i<=n;i++){
			rank.add(0);
			parent.add(i);
			sizeArray.add(1);
		}
	}



	public int findUParent(int node){
		if(node == parent.get(node)){
			return node;
		}
		int ulp = findUParent(parent.get(node));
		parent.set(node,ulp);
		return ulp;
	}


	public void unionRank(int u,int v){
		int ulp_u = findUParent(u);
		int ulp_v = findUParent(v);

		if(ulp_u == ulp_v){
			return;
		}
		if(rank.get(ulp_u)<rank.get(ulp_v)){
			parent.set(ulp_u,ulp_v);
		}
		else if(rank.get(ulp_u)>rank.get(ulp_v)){
			parent.set(ulp_v,ulp_u);
		}
		else{
			parent.set(ulp_v,ulp_u);
			int rankU = rank.get(ulp_u);
			rank.set(ulp_u,rankU+1);
		}
	}

	public void unionSize(int u,int v){
		int ulp_u = findUParent(u);
		int ulp_v = findUParent(v);

		if(ulp_u == ulp_v){
			return;
		}
		if(sizeArray.get(ulp_u)<sizeArray.get(ulp_v)){
			parent.set(ulp_u,ulp_v);
			sizeArray.set(ulp_v,sizeArray.get(ulp_v)+sizeArray.get(ulp_u));
		}
		else{
			parent.set(ulp_v,ulp_u);
			sizeArray.set(ulp_u,sizeArray.get(ulp_v)+sizeArray.get(ulp_u));
		}
		return;
	}
}

class Main{
	public void main(String[] args){
		DisjointSet ds = new DisjointSet(7);
		ds.unionRank(1,2);
		ds.unionRank(2,3);
		ds.unionRank(4,5);
		ds.unionRank(6,7);
		ds.unionRank(5,6);

		if(ds.findUParent(3)==ds.findUParent(7)){
			System.out.println("SAME");
		}
		else{
			System.out.println("NOT SAME");
		}

		ds.unionRank(3,7);
		if(ds.findUParent(3)==ds.findUParent(7)){
			System.out.println("SAME");
		}
		else{
			System.out.println("NOT SAME");
		}

	}
}