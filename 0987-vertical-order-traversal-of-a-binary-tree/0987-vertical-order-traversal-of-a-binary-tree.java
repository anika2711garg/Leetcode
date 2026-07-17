class Solution {

    static class Tuple {
        TreeNode node;
        int row; 
        int col;
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            
            int x = tuple.col;
            int y = tuple.row;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, y + 1, x - 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, y + 1, x + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }
}
