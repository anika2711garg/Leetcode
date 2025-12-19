class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map <Integer, Integer> losscount = new HashMap<>();

        for( int[] m: matches)
            {
                int winner = m[0];
                int loser = m[1];

                losscount.putIfAbsent(winner,0);
                losscount.put(loser, losscount.getOrDefault(loser, 0) + 1);
            }

                List<Integer> zeroloss = new ArrayList<>();
                List<Integer> oneloss = new ArrayList<>();
                

                for( int player: losscount.keySet())
                    {
                        if (losscount.get(player) == 0)
                        {
                            zeroloss.add(player);
                        }
                        else if(losscount.get(player) == 1)
                        {
                            oneloss.add(player);
                        }
                    }



                Collections.sort(zeroloss);
                Collections.sort(oneloss);
               
                List<List<Integer>> ans = new ArrayList<>();
                ans.add(zeroloss);
                ans.add(oneloss);

                
        return ans;
    }
}