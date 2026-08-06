class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[]val:invocations){
            int ai=val[0],bi=val[1];
            map.computeIfAbsent(ai,t->new ArrayList<>()).add(bi);
        }
        //now check all the nodes we can go from k
        int[]visited=new int[n];
        dfs(k,map,visited);
        for(int i=0;i<n;i++){
            if(visited[i]==1)continue;
            else{
                //checking can we visit suspected from a non suspected-nobody can be deleted scene
                for(int val:map.getOrDefault(i,Collections.emptyList())){
                    if(visited[val]==1){
                        List<Integer>ans=new ArrayList<>();
                        for(int j=0;j<n;j++)ans.add(j);
                        return ans;
                    }
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void dfs(int node,Map<Integer,List<Integer>> map,int[]visited){
       if(visited[node]!=0)return;
       visited[node]=1;
        for(int val:map.getOrDefault(node,Collections.emptyList())){
            dfs(val,map,visited);
        }
    }
}