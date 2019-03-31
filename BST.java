public class BST<T extends Comparable<T>> {

    private BSTNode<T> root;

    public BST(){

        root = null;    //first initializes root to equal null

    }

    public boolean find(T value){

        return find(root, value);
    }

    private boolean find(BSTNode<T> node, T value) {

        if (node == null) {
            return false;
        }

            if (node.getData().compareTo(value) == 0) {

                return true; //means they are equal
            } else if (node.getData().compareTo(value) > 0) {

                return find(node.getRight(), value);
            } else {

                return find(node.getLeft(), value);
            }

    }



    public void insert(T value){

            root = insert(root, value);

        }

    private BSTNode<T> insert(BSTNode<T> node, T value){

        if(node == null){

            BSTNode<T> newNode = new BSTNode<T>(value);
            return newNode;
        }
//determine if value is < or > the root
        if(node.getData().compareTo(value) < 0){
            node.setLeft(insert(node.getLeft(), value));
        }
        else{
            node.setRight(insert(node.getRight(), value));
        }

        return node;	//keeps link to parent
    }


    public void print(){
        print(root); //starts at root
    }


    private void print(BSTNode<T> node){
        if(node!= null){
            print(node.getLeft());
            System.out.println(node.getData());
            print(node.getRight());
        }
    }


    private T removeSmallest(BSTNode<T> node){

        if(node.getLeft().getLeft() == null){
            T smallest = node.getLeft().getData();  //left side is always smallest in subtree
            node.setLeft(node.getLeft().getRight()); //shifts up

            return smallest;
        }
        else{

            return removeSmallest(node.getLeft());
        }

    }

    public void delete(T item){

        root = delete(root, item);  //updates the root if needed
    }


    BSTNode<T> delete(BSTNode<T> node, T value) {

            if (node == null) {
                return null;
            }

            if(value.compareTo(node.getData())==0) {

                if (node.getLeft() == null) { //0 or 1 children
                    return node.getRight();

                } else if (node.getRight() == null) { //0 or 1 children

                    return node.getLeft();

                } else {    //has more than 1 child

                    if (node.getRight().getLeft() == null) {    //checks for lower number in subtree
                        node.setData(node.getRight().getData());    //replaces with right BSTNode
                        node.setRight(node.getRight().getRight());

                    } else {
                        node.setData(removeSmallest(node.getRight()));  //
                    }

                    return node;
                }//else w/ +1 child

            } else if(value.compareTo(node.getData()) > 0) {
                node.setLeft(delete(node.getLeft(), value));

            }

            else{
                node.setRight(delete(node.getRight(), value));

            }

            return node;
        }


    }

