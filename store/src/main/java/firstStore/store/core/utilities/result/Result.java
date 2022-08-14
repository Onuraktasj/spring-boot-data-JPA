package firstStore.store.core.utilities.result;

public class Result {

    private boolean success;

    private String messsage;

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success,String messsage){
        this(success);
        this.messsage = messsage;
    }

    public boolean isSuccess(){return  this.success;}

    public String getMesssage(){return  this.messsage;}


}