package interfaces;

/**
 * Created by GIS on 16/03/2018.
 */

public interface ApiResponde {

    public interface ApiResponse<T> {
        void OnResponse(T data);
        void OnError(Throwable t);
    }

}
