package firstStore.store.core.utilities.result;

public class SuccessResult extends  Result {


    public SuccessResult() {
        super(true);
    }

    public SuccessResult( String messsage) {
        super(true, messsage);
    }
}

