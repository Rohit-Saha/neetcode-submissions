class TreeMap {

    class TreeNode {
        int val;
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        this.root = insertIntoBST(this.root, key, val);
    }

    private TreeNode insertIntoBST(TreeNode root, int key, int val) {
        if(root == null) {
            return new TreeNode(key, val);
        }

        if(key < root.key) {
            root.left = insertIntoBST(root.left, key, val);
        } else if(key > root.key){
            root.right = insertIntoBST(root.right, key, val);
        } else {
            root.key = key;
            root.val = val;
        }

        return root;
    }

    public int get(int key) {
        TreeNode curr = this.root;

        while(curr != null) {
            if(key < curr.key) {
                curr = curr.left;
            } else if(key > curr.key) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return -1;
    }

    public int getMin() {
        if(root == null) {
            return -1;
        }
        while(root != null && root.left !=null) {
            root = root.left;
        }
        return root.val;
    }

    public int getMax() {
        if(root == null) {
            return -1;
        }
        while(root != null && root.right !=null) {
            root = root.right;
        }
        return root.val;
    }

    public void remove(int key) {
       this.root = deleteNode(this.root, key);
    }

    private TreeNode findMinNode(TreeNode root) {
        while(root != null && root.left !=null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) {
            return null;
        }

        if(key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMinNode(root.right);
                root.val = minNode.val;
                root.key = minNode.key;
                root.right = deleteNode(root.right, minNode.key);
            }
        }
        return root;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<>();
        inorder(this.root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.key);
        inorder(root.right, list);
    }
}
