
public class DAG {
	private int vert; // # of vertices in graph
    private int edge; // # of edges in graph
    private int[][] adj; // adjacency list for vertex v - 2D array
    private int[] outdegree; // out degree of vertex v
    private int[] indegree; // in degree of vertex v
    private int[] visited;  // vertices that have been visited
   
//constructor to initialize and empty graph with size V
public DAG(int vert){
    if(vert<0){
        throw new IllegalArgumentException("Number of vertices in the DAG must be greater than 0.");
    }
    else{
        this.vert = vert;
        this.edge = 0;
        
        indegree = new int[vert];
    outdegree = new int[vert];
    visited = new int[vert];
    adj = new int[vert][vert];
    for(int i = 0; i<vert; i++){//sets up an empty graph in 2D array
	for(int j=0;j<vert;j++){
	    adj[i][j] = 0;
	}
    }
    }
}

//returns number of vertices in DAG
public int V(){
    return vert;
}

//returns number of edges in DAG
public int E(){
    return edge;
}

//throws illegal exception if the vertex put in, is out of bounds
private void validateVertex(int v){
    if((v<0)||(v>=vert)){
        throw new IllegalArgumentException("Edgeless than one means no vertices are joined, and if there is a cycle it cannot be moved");
    }
}

//adds directed edge from v to w
public void addEdge(int v, int w){
    validateVertex(v);
validateVertex(w);
adj[v][w]=1;
indegree[w]++;
outdegree[v]++;
edge++;
}

//Removes an edge from v to w
public void removeEdge(int v, int w){
    validateVertex(v);
validateVertex(w);
adj[v][w]=0;
indegree[w]--;
outdegree[v]--;
edge--;
}

//returns the number of directed edges out of vertex v
public int outdegree(int v){
	validateVertex(v);
return outdegree[v];
}

//returns the number of directed edges into vertex v
public int indegree(int v){
	validateVertex(v);
return indegree[v];
}

//returns the vertices adjacent from vertex v
public int[] adj(int v){
	validateVertex(v);
int[] temp = new int[outdegree[v]];
int count =0;
for(int i=0;i<vert;i++){
    if(adj[v][i]==1){
	temp[count]=i;
	count++;
	    }
}
return temp;
}

//returns true if the graph contains a cycle, else false
public boolean hasCycle(boolean hasCycle){
hasCycle=false;
int count = 0;
for(int i =0;i<vert;i++){
	visited[count]=i;
	for(int j = 0; j<vert;j++){
		for(int k=0;k<vert;k++){
			if(visited[k]==j && adj[i][j]==1){
				hasCycle=true;
				return hasCycle;
			}
		}	
	}
	count++;
}
return hasCycle;
}


//This public function is used to find the lowest commond ancestor in a directed acyclic graph
public int findLCA(int v, int w){
validateVertex(v);
validateVertex(w);
hasCycle(false);
if(edge>0 && !hasCycle(false)){
	return LCAUtil(v,w);
}
else{
	throw new IllegalArgumentException("This graph is not an acyclic graph.");
}
}

//helper function for LCA
private int LCAUtil(int v, int w){
int[] vArr = new int[edge];
int[] wArr = new int[edge];
boolean[] vMarked = new boolean[vert];
boolean[] wMarked = new boolean[vert];
int vCount =0;
int wCount = 0;
vArr[vCount]=v;
wArr[wCount]=w;
for(int j=0; j<vert;j++){//mark all vertices as not been visited yet
	vMarked[j]=false;
	wMarked[j]=false;
}
for(int i =0;i<vert;i++){
	vMarked[v] =true;
	wMarked[w] =true;
	for(int j = 0; j<vert;j++){
		if(adj[i][j]==1 && vMarked[i]){
			vCount++;
			vArr[vCount]=j;
			vMarked[j]=true;
		}
		if(adj[i][j]==1 && wMarked[i]){
			wCount++;
			wArr[wCount]=j;
			wMarked[j]=true;
		}
		if(wArr[wCount]==vArr[vCount]){
			return wArr[wCount];
		}
	}
}
return -1;//returns -1 if no ancestor found
}  
}
