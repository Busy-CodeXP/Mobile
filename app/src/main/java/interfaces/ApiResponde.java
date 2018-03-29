package interfaces;

import model.Usuario;

/**
 * Created by GIS on 16/03/2018.
 */

public interface ApiResponde {

    public interface ApiResponse<T> {
        void OnSucess(T data);
        void OnError(Throwable t);
    }

}
