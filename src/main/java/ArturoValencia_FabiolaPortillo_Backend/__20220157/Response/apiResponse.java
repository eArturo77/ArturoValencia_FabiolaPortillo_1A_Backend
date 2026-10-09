package ArturoValencia_FabiolaPortillo_Backend.__20220157.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class apiResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public apiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public apiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }



}
