public class BSTNode<T> {
//similar class to node with additions of setting right and setting left rather than just next such as a regular node
    private T data;
    BSTNode<T> left;
    BSTNode<T> right;

    public BSTNode(T data){

        this.data = data;
        this.left = null;
        this.right = null;

    }

    public BSTNode<T> getLeft() {

        return left;
    }

    public BSTNode<T> getRight(){

        return right;
    }

    public void setLeft(BSTNode<T> node){

        left = node;
    }

    public void setRight(BSTNode<T> node){
        right = node;
    }


    public T getData(){

        return data;
    }

    public void setData(T ndata){

        data = ndata;
    }

}
